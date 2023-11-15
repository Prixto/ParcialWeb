package com.example.parcial.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="LibrosJFSD")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nombre;
    private String autor;

    @OneToOne
    @JoinColumn(name = "biblioteca_id")
    private Biblioteca biblioteca;

}
