package com.example.parcial.controllers;

import com.example.parcial.models.dto.BibliotecaDTO;
import com.example.parcial.models.entity.Biblioteca;
import com.example.parcial.models.services.IBibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bibliotecas")
public class BibliotecaRestController {
    @Autowired
    private IBibliotecaService iBibliotecaService;

    @GetMapping("/index")
    public List<BibliotecaDTO> index (){
        List<Biblioteca> bibliotecas = iBibliotecaService.findAll();

        return bibliotecas.stream().
                map(BibliotecaDTO::new)
                .collect(Collectors.toList());
    }


}
