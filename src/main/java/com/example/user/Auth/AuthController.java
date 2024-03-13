package com.example.user.Auth;


import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.example.user.Users.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;
    private final PasswordValidator passwordValidator;

    
    @PostMapping(value = "login")
    //ResponseEntity va a representar toda la respuesta HTTP incluyendo encabezados y cuerpo de respuesta. Flexibilidad
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) //buscar al usuario que esta autenticado
    //public String login()
    {
        //return ResponseEntity.ok(authService.login(request)); 
        return ResponseEntity.ok(authService.login(request)); //esto estará entregando un objeto vacio
        //return "Login from public endpoint";
    }
    
    @PostMapping(value = "register") //para buscar un nuevo registro de usuario.
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        if (!isValidEmail(request.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse("Invalid email format"));
        }
        if (!passwordValidator.isValid(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse("Invalid password format"));
        }
        return ResponseEntity.ok(authService.register(request));
    }
    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static class PasswordValidator {
        private final String passwordRegex;

        public PasswordValidator(String passwordRegex) {
            this.passwordRegex = passwordRegex;
        }

        public boolean isValid(String password) {
            Pattern pattern = Pattern.compile(passwordRegex);
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        }
    }
}
