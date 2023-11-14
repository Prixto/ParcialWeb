package com.example.parcial.models.dto;

import com.example.parcial.models.entity.Biblioteca;
import lombok.Data;

@Data
public class BibliotecaDTO {
    String nombre;
    String direccion;
    String ciudad;

    public BibliotecaDTO(Biblioteca biblioteca){
        this.nombre = biblioteca.getNombre();
        this.direccion = biblioteca.getDireccion();
        this.ciudad = biblioteca.getCiudad();
    }

}
