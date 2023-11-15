package com.example.parcial.controllers;

import com.example.parcial.models.dto.BibliotecaDTO;
import com.example.parcial.models.dto.LibroDTO;
import com.example.parcial.models.entity.Biblioteca;
import com.example.parcial.models.entity.Libro;
import com.example.parcial.models.services.IBibliotecaService;
import com.example.parcial.models.services.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/libros")
public class LibroRestController {
    @Autowired
    private ILibroService iBibliotecaService;

    @GetMapping("/index")
    public List<LibroDTO> index (){
        List<Libro> libros = iBibliotecaService.findAll();
        return libros.stream().
                map(libro -> new LibroDTO(libro,libro.getBiblioteca()))
                .collect(Collectors.toList());
    }
}
