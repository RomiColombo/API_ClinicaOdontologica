package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDireccionRepository extends JpaRepository <Direccion, Long>{
}
