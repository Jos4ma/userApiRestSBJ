// package com.example.user;


// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import java.time.LocalDateTime;
// import java.util.Collections;

// import jakarta.servlet.http.HttpServletRequest;

// import org.junit.jupiter.api.Test;
// //import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;


// @SpringBootTest
// public class EmployeeTest {

//     @Test
//     public void testToEmployeeResponse() {
//         // Creamos un objeto HttpServletRequest mock
//         HttpServletRequest request = mock(HttpServletRequest.class);

//         // Configuramos el comportamiento esperado del mock
//         String expectedToken = "jwtToken";
//         when(request.getAttribute("jwtToken")).thenReturn(expectedToken);

//         // Creamos un objeto Employeee
//         Employee employee = new Employee();
//         employee.setId(1L);
//         employee.setName("John");
//         employee.setPassword("password");
//         employee.setEmail("john@example.com");
//         employee.setIsactive(true);
//         employee.setPhones(Collections.emptyList());

//         // Llamamos al método toEmployeeResponse() para obtener la respuesta del empleado
//         Employee.EmployeeResponse response = employee.toEmployeeResponse(request);

//         // Verificamos que los campos sean los esperados
//         assertEquals(1L, response.getId());
//         assertEquals(true, response.getIsactive());
//         assertEquals(expectedToken, response.getToken());
//         // Verifica otros campos si es necesario
//     }
// }
