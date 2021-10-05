package com.example.ClinicaOdontologica.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration

//Para encriptar necesitamos esto
public class PasswordEncoder {

    //Este es el BEAN que spring va a usar para encriptar
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
