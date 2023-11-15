package com.example.parcial.controllers;

import com.example.parcial.models.dto.BibliotecaDTO;
import com.example.parcial.models.dto.LibroDTO;
import com.example.parcial.models.entity.Biblioteca;
import com.example.parcial.models.entity.Libro;
import com.example.parcial.models.services.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/libros")
public class LibroRestController {
    @Autowired
    private ILibroService iLibroService;

    @GetMapping("/index")
    public List<LibroDTO> index (){
        List<Libro> libros = iLibroService.findAll();
        return libros.stream().
                map(libro -> new LibroDTO(libro,libro.getBiblioteca()))
                .collect(Collectors.toList());
    }

    //Metodo Create
    @PostMapping("/crear")
    public ResponseEntity<Libro> crearLibro(@RequestBody LibroDTO libroDTO) {
        Libro nuevoLibro = iLibroService.crear(libroDTO.toEntity());
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    //Metodo Delete
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        iLibroService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Metodo Update
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id,
                                                           @RequestBody LibroDTO libroDTO) {
        Libro libroExistente = iLibroService.findById(id);

        if (libroExistente != null) {
            libroExistente.setNombre(libroDTO.getNombre());

            iLibroService.guardar(libroExistente);

            return new ResponseEntity<>(libroExistente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
