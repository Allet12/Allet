package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_URL = "http://localhost:8080/allet/employee";

    private static Employee employee;

    @BeforeAll
    public static void setup(){
        employee = EmployeeFactory.createEmployee(7888, "Allet2", "Mngome2", "allet2@gmail.com", "0721047884", "0210976543");
    }

    @Test
    void a_create() {
        String url = Base_URL + "/create";
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(employee.getStatusCode(), HttpStatus.OK);
        Employee empSaved = postResponse.getBody();
        assertEquals(employee.getEmployeeNumber(), empSaved.getEmployeeNumber());
        System.out.println("Saved data :" + empSaved);
    }

    @Test
    void b_read() {
        String url = Base_URL + "/read/" +employee.getEmployeeNumber();
        System.out.println("URL:"+ url);
        ResponseEntity<Employee> response = restTemplate.getForEntity(url, Employee.class);
        assertEquals(employee.getEmployeeNumber(), response.getBody().getEmployeeNumber());
        System.out.println("Read :" + response.getBody());
    }

    @Test
    void c_update() {
        String url = Base_URL + "/update";
        Employee newEmployee = new Employee.Builder()
                .copy(employee)
                .setEmployeeNumber(455)
                .Build();
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, newEmployee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Employee empUpdated = postResponse.getBody();
        assertEquals(newEmployee.getEmployeeNumber(), empUpdated.getEmployeeNumber());
        System.out.println("Updated employee: " + empUpdated);
    }


//    @Test
//    void delete() {
//    }

    @Test
    void d_getall() {
        String url = Base_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL :");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}