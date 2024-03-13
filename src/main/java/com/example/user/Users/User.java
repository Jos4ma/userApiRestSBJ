package com.example.user.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.List;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String username;
    String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name())); // SimpleGrantedAuthority implementa la interfaz grantedAuthority (granted: otorgar)
    }

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return List.of(new SimpleGrantedAuthority(role.name())); // SimpleGrantedAuthority implementa la interfaz grantedAuthority (granted: otorgar)
    // }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Getters and setters (omitted for brevity)
    // public void setPassword(String password) {
    //     if (!isValidPasswordFormat(password)) {
    //         throw new IllegalArgumentException("El formato de la contraseña no es válido");
    //     }
    //     this.password = password;
    //   }
  
    
    // Método de validación del formato de la contraseña
    // private boolean isValidPasswordFormat(String password) {
    //   if (password == null || password.isEmpty()) {
    //       // Si no se proporciona una expresión regular, cualquier contraseña es válida
    //       return true;
    //   }
    //   Pattern pattern = Pattern.compile(password);
    //   return pattern.matcher(password).matches();
    // }
}



// package com.example.user.Users;

// import java.util.Collection;
// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import jakarta.persistence.Basic;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.persistence.UniqueConstraint;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// @Table(name="user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
// public class User implements UserDetails {
//     @Id
//     @GeneratedValue
//     Integer id;
//     @Basic
//     @Column(nullable = false)
//     String username;
//     @Column(nullable = false)
//     String lastname;
//     String firstname;
//     String country;
//     String password;
//     @Enumerated(EnumType.STRING) 
//     Role role;

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//       return List.of(new SimpleGrantedAuthority((role.name())));
//     }
//     @Override
//     public boolean isAccountNonExpired() {
//        return true;
//     }
//     @Override
//     public boolean isAccountNonLocked() {
//        return true;
//     }
//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }
//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
// }