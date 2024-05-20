package za.ac.cput.controller;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Employee;
import za.ac.cput.service.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String home() {
        return "index.html";
    }
    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @GetMapping("/read/{employeeNumber}")
    public Employee read(@PathVariable Long employeeNumber) {
        return employeeService.read(employeeNumber);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        employeeService.delete(id);
    }

    @GetMapping("/getall")
    public List<Employee> getall(){
        return employeeService.getall();
    }
}
