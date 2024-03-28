package com.example.user;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.List;
import java.util.regex.Pattern;
import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpServletRequest;


@Entity
class Employee {

    @Id 
    private UUID id = UUID.randomUUID();
    private String name;
    private String password;
    private String email;
    @ElementCollection
    private List<Phone> phones;
    private LocalDateTime modified;
    private LocalDateTime lastLogin; // Nueva propiedad para last_login
    private boolean isactive;
    private String passwordRegex;
    

    Employee() {}

    Employee(UUID id, String name, String password, String email, boolean isactive, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.modified = null;
        this.isactive = isactive;
        this.phones = phones;
        this.passwordRegex = "";
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
      if (!isValidPasswordFormat(password)) {
          throw new IllegalArgumentException("El formato de la contraseña no es válido");
      }
      this.password = password;
    }

    public void setEmail(String email) {
      if (!isValidEmailFormat(email)) {
        throw new IllegalArgumentException("El formato del correo electrónico no es válido");
    }
    this.email = email;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public LocalDateTime getLastLogin() {
      return lastLogin;
    }
    public void setLastLogin(LocalDateTime lastLogin) {
      this.lastLogin = lastLogin;
    }

    public boolean getIsactive() {
        return this.isactive;
    }
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }


    private boolean isValidEmailFormat(String email) {
        // Expresión regular para validar el formato de un correo electrónico
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }


        // Getter y setter para 'phones'
        public List<Phone> getPhones() {
          return phones;
      }
  
      public void setPhones(List<Phone> phones) {
          this.phones = phones;
      }

          // Getter y setter para 'passwordRegex'
      public String getPasswordRegex() {
          return passwordRegex;
      }
      public void setPasswordRegex(String passwordRegex) {
          this.passwordRegex = passwordRegex;
      }
          // Método de validación del formato de la contraseña
    private boolean isValidPasswordFormat(String password) {
      if (passwordRegex == null || passwordRegex.isEmpty()) {
          // Si no se proporciona una expresión regular, cualquier contraseña es válida
          return true;
      }
      Pattern pattern = Pattern.compile(passwordRegex);
      return pattern.matcher(password).matches();
  }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.password, employee.password) && Objects.equals(this.email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.password, this.email);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", password='" + this.password + '\'' + ", email='" + this.email + '\'' +'}';
    }
  
    public static class EmployeeResponse {

        private UUID id;
        private LocalDateTime created;
        private LocalDateTime modified;
        private LocalDateTime lastLogin;
        //private String token;
        private boolean isactive;
        private String token;
      

        public EmployeeResponse(UUID id, LocalDateTime created, LocalDateTime modified, LocalDateTime lastLogin, boolean isactive, String token) {
            this.id = id;
            this.created = created;
            this.modified = modified;
            this.lastLogin = lastLogin;
            this.isactive = isactive;
            this.token = token;   
        }

        public UUID getId() {
            return id;
        }
        public void setId(UUID id) {
            this.id = id;
        }

        public LocalDateTime getCreated() {
           return created;
        }
        public void setCreated(LocalDateTime created) {
            this.created = created;
        }

        public LocalDateTime getModified() {
            return modified;
        }
        public String getToken() {
            return token;
        }
        public void setToken(String token) {
            this.token = token;
        }
        public void setModified(LocalDateTime modified) {
            this.modified = modified;
        }

        public LocalDateTime getLastLogin() {
            return lastLogin;
        }
        public void setLastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
        }
        
        public boolean getIsactive() {
             return isactive;
        }
        public void setIsactive(boolean isactive) {
            this.isactive = isactive;
        }
    }
    // public EmployeeResponse toEmployeeResponse() {
    //   return new EmployeeResponse(this.id,LocalDateTime.now());
    // }
    public EmployeeResponse toEmployeeResponse(HttpServletRequest request) {
        LocalDateTime now = LocalDateTime.now();
        String jwtToken = (String) request.getAttribute("jwtToken");
        return new EmployeeResponse(this.id, now, now, now, this.isactive, jwtToken);
    }

    public void updateModifiedTimestamp() {
       this.modified = LocalDateTime.now();
    }

    public void updateLastLoginTimestamp() {
          this.lastLogin = LocalDateTime.now();
    }

}


