package com.example.user.Auth;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//el objetivo es que nos devuelva el token independiente de que es el login o request.
public class AuthResponse {
    String token; 
}