package com.example.ClinicaOdontologica.service;


import com.example.ClinicaOdontologica.model.Direccion;
import com.example.ClinicaOdontologica.repository.IDireccionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DireccionService implements IDireccionService{

    @Autowired
    private IDireccionRepository direccionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public DireccionService(IDireccionRepository direccionRepository, ObjectMapper objectMapper) {
        this.direccionRepository = direccionRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<Direccion> buscarDireccion(Long id) {
        Optional<Direccion> direccion = direccionRepository.findById(id);
        return direccion;
    }
}
