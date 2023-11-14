package com.example.parcial.models.repository;

import com.example.parcial.models.entity.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends CrudRepository <Libro,String> {
}
