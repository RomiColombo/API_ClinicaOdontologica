package com.example.ClinicaOdontologica.model.DTO;

public class DireccionDTO {

    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    public DireccionDTO(){

    }

    public DireccionDTO(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}