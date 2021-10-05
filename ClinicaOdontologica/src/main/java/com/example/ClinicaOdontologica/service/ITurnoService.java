package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ClinicaOdontologica.model.DTO.TurnoDTO;

import java.util.Collection;

public interface ITurnoService {

    String crearTurno (TurnoDTO turnoDTO);
    Collection<TurnoDTO> listarTodos();
    TurnoDTO buscarTurno(Long id);
    void modificarTurno (TurnoDTO turnoDTO);
    void eliminarTurno (Long id) throws ResourceNotFoundException;
}
