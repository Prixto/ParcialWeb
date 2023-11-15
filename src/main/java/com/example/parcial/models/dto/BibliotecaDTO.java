package com.example.parcial.models.dto;

import com.example.parcial.models.entity.Biblioteca;
import lombok.Data;

@Data
public class BibliotecaDTO {
    Long id;
    String nombre;
    String direccion;
    String ciudad;

    public BibliotecaDTO(Biblioteca biblioteca){
        this.id = biblioteca.getId();
        this.nombre = biblioteca.getNombre();
        this.direccion = biblioteca.getDireccion();
        this.ciudad = biblioteca.getCiudad();
    }

    public Biblioteca toEntity() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(this.id);
        biblioteca.setNombre(this.nombre);
        biblioteca.setDireccion(this.direccion);
        biblioteca.setCiudad(this.ciudad);
        return biblioteca;
    }
}
