package com.example.parcial.models.services;

import com.example.parcial.models.entity.Biblioteca;
import com.example.parcial.models.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaServiceImpl implements IBibliotecaService{
    @Autowired
    private BibliotecaRepository bibliotecaRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Biblioteca> findAll() {
        return (List<Biblioteca>) bibliotecaRepository.findAll();
    }

    @Override
    public Biblioteca crear (Biblioteca biblioteca){
        Biblioteca newBiblioteca = new Biblioteca();
        newBiblioteca.setNombre(biblioteca.getNombre());
        newBiblioteca.setCiudad(biblioteca.getCiudad());
        newBiblioteca.setDireccion(biblioteca.getDireccion());
        return bibliotecaRepository.save(newBiblioteca);
    }

    @Override
    public void eliminar(Long id) {
        bibliotecaRepository.deleteById(id);
    }

    @Override
    public Biblioteca findById(Long id) {
        Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);
        return bibliotecaOptional.orElse(null);
    }

    @Override
    public Biblioteca guardar(Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    }
}
