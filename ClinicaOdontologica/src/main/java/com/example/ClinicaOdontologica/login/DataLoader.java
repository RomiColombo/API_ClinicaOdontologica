package com.example.ClinicaOdontologica.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//Esta clase me inserta datos en la BDD
//Siempre que queramos agregar datos a la BDD cuando levanta el servidor podemos hacerlo asi
@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Vamo a encriptar la contraseña
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //Esto va a generar el password encriptado
        String passwordUser = passwordEncoder.encode("passwordUsuario");
        String passwordAdmin = passwordEncoder.encode("passwordAdmin");

        //Cuando levante nuestra aplicacion va a generar estos dos usuarios
        userRepository.save(new AppUser("Romina", "Romi", "holasoyromi@mail.com",passwordAdmin, AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("Usuario", "Usuario", "usuario@mail.com",passwordUser, AppUsuarioRoles.USER));
    }
}
