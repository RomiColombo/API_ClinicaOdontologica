package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.model.DTO.OdontologoDTO;
import com.example.ClinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {


    @Qualifier("OdontologoService")
    private final OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/cargarOdontologo")
    public void crearOdontologo(@RequestBody OdontologoDTO odontologo){
        odontologoService.crearOdontologo(odontologo);
    }

    @GetMapping(value = "/listarOdontologos")
    public Collection<OdontologoDTO> listarOdontologos(){
        return odontologoService.listarTodos();
    }

    @GetMapping(value = "/buscar/{id}")
    @ResponseBody
    public OdontologoDTO buscarOdontologo(@PathVariable("id") Long id){
        return odontologoService.buscarOdontologo(id);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public String eliminarOdontologo(@PathVariable("id") Long id){
        return odontologoService.eliminarOdontologo(id);
    }

    @PutMapping (value="/actualizar")
    public void actualizarOdontologo(@RequestBody OdontologoDTO odontologoModificado){
        odontologoService.modificarOdontologo(odontologoModificado);
    }
}