package com.example.ClinicaOdontologica.model;

import javax.persistence.*;

@Entity
@Table
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "direccion_sequence")
    @SequenceGenerator(name = "direccion_sequence", sequenceName = "direccion_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String calle;
    @Column
    private int numero;
    @Column
    private String localidad;
    @Column
    private String provincia;


    public Direccion() {
    }

    public Direccion( String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
