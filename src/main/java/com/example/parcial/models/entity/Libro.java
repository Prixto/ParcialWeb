package com.example.parcial.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="LibrosJFSD")
public class Libro implements Serializable {
    @Id
    private String nombre;
    private String autor;

    @OneToOne
    @JoinColumn(name = "biblioteca_nombre")
    private Biblioteca biblioteca;

}
