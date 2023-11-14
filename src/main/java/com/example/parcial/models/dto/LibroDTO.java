package com.example.parcial.models.dto;

import com.example.parcial.models.entity.Biblioteca;
import com.example.parcial.models.entity.Libro;
import com.example.parcial.models.repository.LibroRepository;
import lombok.Data;

@Data
public class LibroDTO {
    String nombre;
    String autor;
    Biblioteca biblioteca;

    public LibroDTO(Libro libro, Biblioteca biblioteca){
        this.nombre = libro.getNombre();
        this.autor = libro.getAutor();
        this.biblioteca = biblioteca;
    }
}
