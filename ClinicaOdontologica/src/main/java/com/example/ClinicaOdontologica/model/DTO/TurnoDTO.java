package com.example.ClinicaOdontologica.model.DTO;

import com.example.ClinicaOdontologica.model.Odontologo;
import com.example.ClinicaOdontologica.model.Paciente;
import com.example.ClinicaOdontologica.model.Turno;

import java.io.Serializable;

public class TurnoDTO implements Serializable {

    private Long id;
    private String fecha;
    private Odontologo odontologo;
    private Paciente paciente;

    public TurnoDTO(){

    }

    public TurnoDTO(Turno turno) {
        this.fecha = fecha;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}