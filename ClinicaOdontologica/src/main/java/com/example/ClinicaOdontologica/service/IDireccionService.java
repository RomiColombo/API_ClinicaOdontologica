package com.example.ClinicaOdontologica.service;


import com.example.ClinicaOdontologica.model.Direccion;

import java.util.Optional;

public interface IDireccionService {
    Optional<Direccion> buscarDireccion(Long id);
}