package com.example.user;


import org.springframework.data.jpa.repository.JpaRepository;

//import com.example.user.;

//public interface EmployeeRepository extends JpaRepository<User,Integer> {
interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //minuto 36 sobre la relacion con la tabla
    boolean existsByEmail(String email);
    
}
