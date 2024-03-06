package com.example.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
class EmployeeController {

  private final EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/employees")
  List<Employee> all() {
    return repository.findAll();
  }
 

  @PostMapping("/employees")
  public Employee.EmployeeResponse createEmployee(@RequestBody Employee employee) {
      // Actualizar la propiedad "modified" 
      if (repository.existsByEmail(employee.getEmail())) {
        throw new DuplicateEmailException(employee.getEmail());
    }
      employee.setPasswordRegex("^[a-zA-Z0-9@#$%^&+=]{8,}$");
      
      employee.updateModifiedTimestamp();
      employee.updateLastLoginTimestamp();
      // LLama al servicio para guardar el nuevo empleado en db
      Employee savedEmployee = repository.save(employee);
  
      // Convert the saved employee to EmployeeResponse (con el ID, created y modified)
      return savedEmployee.toEmployeeResponse();
  }
  
  // Single item
  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  // @PutMapping("/employees/{id}")
  // Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
    
  //   return repository.findById(id)
  //     .map(employee -> {
  //       employee.setName(newEmployee.getName());
  //       employee.setRole(newEmployee.getRole());
  //       return repository.save(employee);
  //     })
  //     .orElseGet(() -> {
  //       newEmployee.setId(id);
  //       return repository.save(newEmployee);
  //     });
  // }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}


