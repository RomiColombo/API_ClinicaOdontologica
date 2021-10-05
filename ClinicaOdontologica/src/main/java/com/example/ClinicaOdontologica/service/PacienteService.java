package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.DTO.PacienteDTO;
import com.example.ClinicaOdontologica.model.Paciente;
import com.example.ClinicaOdontologica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void crearPaciente(PacienteDTO nuevoPaciente) {

        Paciente paciente = objectMapper.convertValue(nuevoPaciente, Paciente.class);
        if (nuevoPaciente != null){
            pacienteRepository.save(paciente);
        }

    }

    @Override
    public Collection<PacienteDTO> listarTodos() {

        List<Paciente> pacientes = pacienteRepository.findAll();

        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente: pacientes) {
            pacientesDTO.add(objectMapper.convertValue(paciente, PacienteDTO.class));
        }

        return pacientesDTO;

    }

    @Override
    public PacienteDTO buscarPaciente(Long id) {

        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return objectMapper.convertValue(paciente, PacienteDTO.class);
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteModificado) {

        Paciente paciente = objectMapper.convertValue(pacienteModificado, Paciente.class);

        if (pacienteRepository.findById(paciente.getId()).isPresent()) {
            pacienteRepository.save(paciente);
        }
    }

    @Override
    public String eliminarPaciente(Long id)  {


        if (pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            return "Se ha eliminado al paciente con ID "+ id;
        }
        return "El ID ingresado no coincide con un paciente";
    }
}