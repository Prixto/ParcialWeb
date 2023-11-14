package com.example.parcial.models.services;

import com.example.parcial.models.entity.Biblioteca;
import com.example.parcial.models.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BibliotecaServiceImpl implements IBibliotecaService{
    @Autowired
    private BibliotecaRepository bibliotecaRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Biblioteca> findAll() {
        return (List<Biblioteca>) bibliotecaRepository.findAll();
    }
}
