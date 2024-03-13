// import static org.junit.Assert.assertNotNull;

// import java.time.LocalDateTime;
// import java.util.Collections;
// import java.util.UUID;

// import javax.servlet.http.HttpServletRequest;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.Mockito;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
// @SpringBootTest
// @ContextConfiguration(classes = UserApplication.class) // Reemplaza YourApplication.class con la clase principal de tu aplicación
// public class EmployeeTest {

//     @Test
//     public void testToEmployeeResponse() {
//         // Creamos un mock para HttpServletRequest
//         HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

//         // Configuramos el comportamiento esperado del mock
//         String expectedToken = "jwtToken";
//         Mockito.when(request.getAttribute("jwtToken")).thenReturn(expectedToken);

//         // Creamos un objeto Employee
//         Employee employee = new Employee();
//         employee.setId(UUID.randomUUID());
//         employee.setName("John");
//         employee.setPassword("password");
//         employee.setEmail("john@example.com");
//         employee.setIsactive(true);
//         employee.setPhones(Collections.emptyList());

//         // Llamamos al método toEmployeeResponse() para obtener la respuesta del empleado
//         Employee.EmployeeResponse response = employee.toEmployeeResponse(request);

//         // Verificamos que los campos sean los esperados
//         assertNotNull(response.getId());
//         assertNotNull(response.getCreated());
//         assertNotNull(response.getModified());
//         assertNotNull(response.getLastLogin());
//         assertNotNull(response.getToken());
//         assertNotNull(response.getIsactive());
//     }
// }
