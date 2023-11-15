package com.example.parcial.models.services;

import com.example.parcial.models.entity.Libro;
import com.example.parcial.models.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements ILibroService{
    @Autowired
    private LibroRepository libroRepository;
    @Override
    public List<Libro> findAll() {
        return (List<Libro>) libroRepository.findAll();
    }

    @Override
    public Libro crear (Libro Libro){
        Libro newLibro = new Libro();
        newLibro.setNombre(Libro.getNombre());
        newLibro.setAutor(Libro.getAutor());
        newLibro.setBiblioteca(Libro.getBiblioteca());
        return libroRepository.save(newLibro);
    }

    @Override
    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public Libro findById(Long id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        return libroOptional.orElse(null);
    }

    @Override
    public Libro guardar(Libro Libro){
        return libroRepository.save(Libro);
    }
}
