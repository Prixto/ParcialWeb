package com.example.parcial.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BibliotecasJFSD")
public class Biblioteca {

    @Id
    private String nombre;
    private String direccion;
    private String ciudad;
}
