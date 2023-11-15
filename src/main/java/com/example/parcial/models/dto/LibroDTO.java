package com.example.parcial.models.dto;

import com.example.parcial.models.entity.Biblioteca;
import com.example.parcial.models.entity.Libro;
import lombok.Data;

@Data
public class LibroDTO {
    Long id;
    String nombre;
    String autor;
    Biblioteca biblioteca;

    public LibroDTO(Libro libro, Biblioteca biblioteca){
        this.id = libro.getId();
        this.nombre = libro.getNombre();
        this.autor = libro.getAutor();
        this.biblioteca = biblioteca;
    }

    public Libro toEntity() {
        Libro libro = new Libro();
        libro.setId(this.id);
        libro.setAutor(this.nombre);
        libro.setBiblioteca(this.biblioteca);
        return libro;
    }
}
