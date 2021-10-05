package com.example.ClinicaOdontologica.controller;


import com.example.ClinicaOdontologica.model.DTO.PacienteDTO;
import com.example.ClinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Qualifier("PacienteService")
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/cargarPaciente")
    public void crearPaciente(@RequestBody PacienteDTO paciente){
        pacienteService.crearPaciente(paciente);
    }

    @GetMapping(value = "/listarPacientes")
    public Collection<PacienteDTO> listarPacientes(){
        return pacienteService.listarTodos();
    }

    @GetMapping(value = "/buscar/{id}")
    @ResponseBody
    public PacienteDTO buscarPaciente(@PathVariable("id") Long id){
        return pacienteService.buscarPaciente(id);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id){
        return pacienteService.eliminarPaciente(id);
    }

    @PutMapping (value="/actualizar")
    public void actualizarPaciente(@RequestBody PacienteDTO pacienteModificado){
        pacienteService.modificarPaciente(pacienteModificado);
    }
}