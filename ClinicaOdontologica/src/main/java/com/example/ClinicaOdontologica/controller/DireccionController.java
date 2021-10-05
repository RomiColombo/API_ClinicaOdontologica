package com.example.ClinicaOdontologica.controller;


import com.example.ClinicaOdontologica.model.Direccion;
import com.example.ClinicaOdontologica.service.DireccionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/direccion")
public class DireccionController {

    @Qualifier("DireccionService")
    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping(value ="/buscar/{id}")
    @ResponseBody
    public Optional<Direccion> buscarDireccion(@PathVariable("id") Long id){
        return direccionService.buscarDireccion(id);
    }
}
