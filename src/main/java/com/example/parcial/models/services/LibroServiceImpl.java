package com.example.parcial.models.services;

import com.example.parcial.models.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements ILibroService{
    @Autowired
    private LibroRepository libroRepository;
    @Override
    public List<Libro> findAll() {
        return (List<Libro>) libroRepository.findAll();
    }
}
