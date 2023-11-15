package com.example.parcial.models.services;

import com.example.parcial.models.entity.Libro;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ILibroService {
    public List<Libro> findAll();

    public Libro crear(@RequestBody Libro libro);
    public void eliminar(@PathVariable Long id);

    public Libro findById(Long id);

    public Libro guardar (Libro libro);
}
