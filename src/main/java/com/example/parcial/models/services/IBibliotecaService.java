package com.example.parcial.models.services;

import com.example.parcial.models.entity.Biblioteca;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface IBibliotecaService {
    public List<Biblioteca> findAll();
    public Biblioteca crear(@RequestBody Biblioteca biblioteca);
    public void eliminar(@PathVariable Long id);

    public Biblioteca findById(Long id);

    public Biblioteca guardar (Biblioteca biblioteca);


}
