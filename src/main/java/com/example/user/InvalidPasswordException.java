package com.example.user;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("La contraseña no cumple con los requisitos de validación.");
    }
}
