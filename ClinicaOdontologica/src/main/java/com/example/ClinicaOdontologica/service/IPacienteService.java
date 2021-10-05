package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.DTO.PacienteDTO;

import java.util.Collection;

public interface IPacienteService {

    void crearPaciente (PacienteDTO pacienteDTO);
    Collection<PacienteDTO> listarTodos();
    PacienteDTO buscarPaciente(Long id);
    void modificarPaciente(PacienteDTO pacienteDTO);
    String eliminarPaciente(Long id);

}