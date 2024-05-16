package za.ac.cput.service;

import za.ac.cput.Domain.Employee;

import java.util.List;

public interface IEmployeeService extends IService<Employee, Long>{

    List<Employee> getall();
}
