package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.DTO.OdontologoDTO;

import java.util.Collection;

public interface IOdontologoService {

    void crearOdontologo (OdontologoDTO odontologo);
    Collection<OdontologoDTO> listarTodos();
    OdontologoDTO buscarOdontologo(Long id);
    void modificarOdontologo(OdontologoDTO odontologo);
    String eliminarOdontologo(Long id);

}