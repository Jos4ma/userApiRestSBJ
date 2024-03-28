package com.example.user;


import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
 // Importación correcta para JUnit 5


public class EmployeeTest3 {

    @Test
    public void testEmployeeConstructor() {
        UUID id = UUID.randomUUID();
        String name = "John Doe";
        String password = "Password123";
        String email = "john.doe@example.com";
        boolean isActive = true;
        List<Phone> phones = new ArrayList<>();

        Employee employee = new Employee(id, name, password, email, isActive, phones);

        assertEquals(id, employee.getId());
        assertEquals(name, employee.getName());
        assertEquals(password, employee.getPassword());
        assertEquals(email, employee.getEmail());
        assertEquals(isActive, employee.getIsactive());
        assertEquals(phones, employee.getPhones());
    }

    @Test
    public void testSetPasswordValidFormat() {
        Employee employee = new Employee();
        String validPassword = "ValidPassword123";

        employee.setPassword(validPassword);

        assertEquals(validPassword, employee.getPassword());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPasswordInvalidFormat() {
        Employee employee = new Employee();
        String invalidPassword = "invalid";

        employee.setPassword(invalidPassword);
    }

    @Test
    public void testSetEmailValidFormat() {
        Employee employee = new Employee();
        String validEmail = "john.doe@example.com";

        employee.setEmail(validEmail);

        assertEquals(validEmail, employee.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetEmailInvalidFormat() {
        Employee employee = new Employee();
        String invalidEmail = "invalidemail";

        employee.setEmail(invalidEmail);
    }

    @Test
    public void testUpdateModifiedTimestamp() {
        Employee employee = new Employee();
        LocalDateTime initialTimestamp = employee.getModified();

        employee.updateModifiedTimestamp();
        LocalDateTime updatedTimestamp = employee.getModified();

        assertNotNull(updatedTimestamp);
        assertNotEquals(initialTimestamp, updatedTimestamp);
    }

    @Test
    public void testUpdateLastLoginTimestamp() {
        Employee employee = new Employee();
        LocalDateTime initialTimestamp = employee.getLastLogin();

        employee.updateLastLoginTimestamp();
        LocalDateTime updatedTimestamp = employee.getLastLogin();

        assertNotNull(updatedTimestamp);
        assertNotEquals(initialTimestamp, updatedTimestamp);
    }

    // You can add more tests as needed
}
