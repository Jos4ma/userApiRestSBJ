package com.example.user;

import java.util.List;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

//import com.example.user.EmployeeController.JwtTokenProvider;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// import org.springframework.beans.factory.annotation.Autowired;
// Importa las clases necesarias para JWT
// import org.springframework.http.ResponseEntity;





@RestController
@RequestMapping("/api/v2")
//@Tag(name = "Companies resourse")
class EmployeeController {

  private final EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  // @GetMapping("/employees")
  // List<Employee> all() {
  //   return repository.findAll();
  // }

  //@Operation(summary = "post a company given a company from body")
  @PostMapping(value = "demo" )
  public Employee.EmployeeResponse createEmployee(HttpServletRequest request, @RequestBody Employee employee) {
    // Actualizar la propiedad "modified"
    

    // if (repository.existsByEmail(employee.getEmail())) {
    //   throw new DuplicateEmailException(employee.getEmail());
    // }
    employee.setPasswordRegex("^[a-zA-Z0-9@#$%^&+=]{8,}$");

    employee.updateModifiedTimestamp();
    employee.updateLastLoginTimestamp();
    // LLama al servicio para guardar el nuevo empleado en db
    Employee savedEmployee = repository.save(employee);

    // Convert the saved employee to EmployeeResponse (con el ID, created y
    // modified)
    return savedEmployee.toEmployeeResponse(request);
  }


  // @DeleteMapping("/employees/{id}")
  // void deleteEmployee(@PathVariable Long id) {
  //   repository.deleteById(id);
  // }

}


