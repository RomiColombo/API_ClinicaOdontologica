package com.example.ClinicaOdontologica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.apache.log4j.Logger;

//Aca le digo que con esta clase voy a controlar todas las excepciones de mi proyecto
@ControllerAdvice
public class GlobalExceptions {


    private static final Logger log = Logger.getLogger(GlobalExceptions.class);

    //Tratar manualmente cada excepcion
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> errorProcesarBadRequest(ResourceNotFoundException ex, WebRequest req){
        log.error(ex.getMessage() + req);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( ex.getMessage());
    }
}
