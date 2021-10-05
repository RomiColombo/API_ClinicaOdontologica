package com.example.ClinicaOdontologica.model.DTO;

import com.example.ClinicaOdontologica.model.Direccion;
import com.example.ClinicaOdontologica.model.Paciente;


import java.io.Serializable;

public class PacienteDTO implements Serializable {

    private Long id;

    private String apellido;
    private String nombre;
    private Integer dni;
    private String email;
    private String fechaAlta;
    private Direccion direccion;

    public PacienteDTO(){

    }

    public PacienteDTO(Paciente paciente) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.direccion = direccion;
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}