package com.example.parcial.models.repository;

import com.example.parcial.models.entity.Biblioteca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends CrudRepository <Biblioteca, String> {
}
