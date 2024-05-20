package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Employee;
import za.ac.cput.repository.EmployeeRepository;
import za.ac.cput.repository.contactRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {
    private contactRepository contactrepository;
    private EmployeeRepository employeerepository;

    @Autowired
    EmployeeService(contactRepository contactrepository, EmployeeRepository employeerepository ){
        this.contactrepository = contactrepository;
        this.employeerepository = employeerepository;
    }

    @Override
    public Employee create(Employee employee){
        contactrepository.save(employee.getContact());
        return  employeerepository.save(employee);
    }

    @Override
    public Employee read(Long employeeNumber){
        return employeerepository.findById(employeeNumber).orElse(null);
    }

    @Override
    public Employee update(Employee employee){
        contactrepository.save(employee.getContact());
        return employeerepository.save(employee);
    }

    @Override
    public List<Employee> getall() {
        return employeerepository.findAll().stream().collect(Collectors.toList());
    }

    public void delete(Long id) {
        //return employeerepository.delete();
    }
}
