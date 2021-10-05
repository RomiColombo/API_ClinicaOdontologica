package com.example.ClinicaOdontologica.model.DTO;

import com.example.ClinicaOdontologica.model.Odontologo;

import java.io.Serializable;

public class OdontologoDTO implements Serializable {

    private Long id;
    private String apellido;
    private String nombre;
    private Integer matricula;

    public OdontologoDTO(){

    }

    public OdontologoDTO(Odontologo odontologo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}