package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.DTO.OdontologoDTO;
import com.example.ClinicaOdontologica.model.Odontologo;
import com.example.ClinicaOdontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ModelMapper modelMapper;

    public OdontologoService(IOdontologoRepository odontologoRepository, ObjectMapper objectMapper, ModelMapper modelMapper) {
        this.odontologoRepository = odontologoRepository;
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public void crearOdontologo(OdontologoDTO nuevoOdontologo) {

        Odontologo odontologo = objectMapper.convertValue(nuevoOdontologo, Odontologo.class);
        if (nuevoOdontologo != null){
           odontologoRepository.save(odontologo);
        }
    }

    @Override
    public Collection<OdontologoDTO> listarTodos() {

        List<Odontologo> odontologos = odontologoRepository.findAll();

        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo: odontologos ) {
            odontologosDTO.add(objectMapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {

        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;

        if(odontologo.isPresent()){
            odontologoDTO = objectMapper.convertValue(odontologo, OdontologoDTO.class);
        }

        return odontologoDTO;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoModificado) {

        Odontologo odontologo = objectMapper.convertValue(odontologoModificado, Odontologo.class);

        if (odontologoRepository.findById(odontologo.getId()).isPresent()){
            odontologoRepository.save(odontologo);
        }
    }

    @Override
    public String eliminarOdontologo(Long id) {
        if (odontologoRepository.findById(id).isPresent()){
            odontologoRepository.deleteById(id);
            return "Se ha eliminado al odontólogo con ID "+ id;
        }
        return "El ID ingresado no coincide con un Odontólogo";
    }
}