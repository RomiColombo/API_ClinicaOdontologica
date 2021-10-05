package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ClinicaOdontologica.model.DTO.TurnoDTO;
import com.example.ClinicaOdontologica.model.Turno;
import com.example.ClinicaOdontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public TurnoService(ITurnoRepository turnoRepository, ObjectMapper objectMapper, ModelMapper modelMapper) {
        this.turnoRepository = turnoRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public String crearTurno(TurnoDTO turno) {

        Turno nuevoTurno = objectMapper.convertValue(turno, Turno.class);

        if (nuevoTurno != null) {
            turnoRepository.save(nuevoTurno);
            return "Se generó un turno";
        }
        else{
            return "No se pudo generar un nuevo turno";
        }
    }

    @Override
    public Collection<TurnoDTO> listarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for(Turno turno: turnos)
            turnosDTO.add(objectMapper.convertValue(turno, TurnoDTO.class));
        return turnosDTO;
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        return objectMapper.convertValue(turno, TurnoDTO.class);
    }

    @Override
    public void modificarTurno(TurnoDTO turno) {
        Turno turnoModificado = objectMapper.convertValue(turno, Turno.class);
        if(turnoRepository.findById(turnoModificado.getId()).isPresent()){
            turnoRepository.save(turnoModificado);
        }
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        if (turnoRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("No existe el turno con el id : " + id);
        }
        else {
            turnoRepository.deleteById(id);
        }
    }
}