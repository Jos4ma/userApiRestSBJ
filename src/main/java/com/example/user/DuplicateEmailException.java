package com.example.user;

class DuplicateEmailException extends RuntimeException {

    DuplicateEmailException(String email) {
        super("El correo " + email + " ya está registrado.");
    }
}
