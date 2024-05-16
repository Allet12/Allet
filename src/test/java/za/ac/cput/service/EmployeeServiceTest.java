package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Contact;
import za.ac.cput.Domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;
    private Employee employee = EmployeeFactory.createEmployee(345L,"Allet", "kgotlelelo", "kgotlello@gmail.com","0721045632", "0219846739");

    @Test
    @Order(1)
    void create() {
        Employee empcreated = service.create(employee);
        assertNotNull(empcreated);
        System.out.println(empcreated);
    }

    @Test
    @Order(2)
    void read() {
        Employee reademp = service.read(employee.getEmployeeNumber());
        assertNotNull(reademp);
        System.out.println(reademp);
    }

    @Test
    @Order(3)
    void update() {
        Contact editContact = new Contact.Builder().copy(employee.getContact()).setMobile("0721047832").Build();
        assertNotNull(editContact);
        Employee editEmployee = new Employee.Builder().copy(employee).setContact(editContact).Build();
        assertNotNull(editEmployee);
        Employee updated = service.update(editEmployee);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void getall() {
        System.out.println(service.getall());
    }
}