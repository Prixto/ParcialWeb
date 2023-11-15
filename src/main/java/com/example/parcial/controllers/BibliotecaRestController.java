package com.example.parcial.controllers;

import com.example.parcial.models.dto.BibliotecaDTO;
import com.example.parcial.models.entity.Biblioteca;
import com.example.parcial.models.services.IBibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("bibliotecas")
public class BibliotecaRestController {
    @Autowired
    private IBibliotecaService iBibliotecaService;

    //Metodo Read
    @GetMapping("/index")
    public List<BibliotecaDTO> index (){
        List<Biblioteca> bibliotecas = iBibliotecaService.findAll();

        return bibliotecas.stream().
                map(BibliotecaDTO::new)
                .collect(Collectors.toList());
    }

    //Metodo Create
    @PostMapping("/crear")
    public ResponseEntity<Biblioteca> crearBiblioteca(@RequestBody BibliotecaDTO bibliotecaDTO) {
        Biblioteca nuevaBiblioteca = iBibliotecaService.crear(bibliotecaDTO.toEntity());
        return new ResponseEntity<>(nuevaBiblioteca, HttpStatus.CREATED);
    }


    //Metodo Delete
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarBiblioteca(@PathVariable Long id) {
            iBibliotecaService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Método Update
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Biblioteca> actualizarBiblioteca(@PathVariable Long id,
                                                           @RequestBody BibliotecaDTO bibliotecaDTO) {
        Biblioteca bibliotecaExistente = iBibliotecaService.findById(id);

        if (bibliotecaExistente != null) {
            bibliotecaExistente.setNombre(bibliotecaDTO.getNombre());

            iBibliotecaService.guardar(bibliotecaExistente);

            return new ResponseEntity<>(bibliotecaExistente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
