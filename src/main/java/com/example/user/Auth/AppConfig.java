package com.example.user.Auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
        @Bean
    public AuthController.PasswordValidator passwordValidator() {
        String passwordRegex = "^[a-zA-Z0-9]{8,}$"; // Expresión regular para contraseñas de al menos 8 caracteres alfanuméricos
        return new AuthController.PasswordValidator(passwordRegex);
    }
}
