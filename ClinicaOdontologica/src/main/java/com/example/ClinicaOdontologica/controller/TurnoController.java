package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ClinicaOdontologica.model.DTO.TurnoDTO;
import com.example.ClinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {


    @Qualifier("TurnoService")
    private final TurnoService turnoService;

    public TurnoController (TurnoService turnoService){
        this.turnoService = turnoService;
    }

    @PostMapping("/cargarTurno")
    void create (@RequestBody TurnoDTO turnoDTO){

        turnoService.crearTurno(turnoDTO);
    }

    @GetMapping("/listarTurnos")
    @ResponseBody
    public Collection<TurnoDTO> listarTurno() {
        return turnoService.listarTodos();
    }

    @GetMapping("buscar/{id}")
    @ResponseBody
    ResponseEntity<TurnoDTO> read(@PathVariable("id") Long id){
        TurnoDTO turno = turnoService.buscarTurno(id);
        return ResponseEntity.ok(turno);
    }

    @PutMapping("/actualizar")
    void update(@RequestBody TurnoDTO turnoDTO){
        turnoService.modificarTurno(turnoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se ha eliminado el turno");
    }

}