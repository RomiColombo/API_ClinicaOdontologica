package com.example.ClinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Odontologos")
public class Odontologo {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private Integer matricula;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Turno> turnos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Odontologo() {
    }

    public Odontologo(String apellido, String nombre, Integer matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
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

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
}