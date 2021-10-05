package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Aca no se programa nada, JPA hace toda la magia
@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

}