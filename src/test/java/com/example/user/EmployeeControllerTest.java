package com.example.user;



import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeController controller;

    @Test
    void testCreateEmployee() throws Exception {
        // Given
        Employee employee = new Employee(/* provide necessary parameters */);
        when(repository.save(any(Employee.class))).thenReturn(employee);

        // When
        mockMvc.perform(post("/api/v2/demo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(/* provide JSON content for employee */))
                .andExpect(status().isOk());

        // Then: Add more assertions as needed
        verify(repository, times(1)).save(any(Employee.class));
    }
}





// import static org.mockito.Mockito.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;

// @SpringBootTest
// @AutoConfigureMockMvc
// @ExtendWith(MockitoExtension.class)
// class EmployeeControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @Mock
//     private EmployeeRepository employeeRepository;

//     @InjectMocks
//     private EmployeeController employeeController;

//     @Test
//     void testCreateEmployee() throws Exception {
//         // Arrange
//         Employee employee = new Employee();
//         // Setear los atributos del empleado si es necesario
//         // employee.setName("Nombre");
//         // employee.setEmail("email@example.com");
//         // ...

//         // Mockear el comportamiento del repositorio para que devuelva un empleado guardado
//         when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

//         // Act y Assert
//         mockMvc.perform(post("/api/v2/demo")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content("{\"name\": \"Nombre\", \"email\": \"email@example.com\", \"password\": \"12345678\"}")) // Aquí debes pasar los datos del empleado en formato JSON
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//                 // Aquí puedes agregar más aserciones para verificar el contenido de la respuesta si es necesario
//     }
// }
