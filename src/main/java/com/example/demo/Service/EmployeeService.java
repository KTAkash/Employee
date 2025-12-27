package com.example.demo.Service;
import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository repo;


    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee addEmployee(Employee emp) {
        return repo.save(emp);
    }

    public Employee updateEmployee(Long id, Employee data) {
        Employee emp = getEmployeeById(id);
        emp.setEmpName(data.getEmpName());
        emp.setEmail(data.getEmail());
        emp.setSalary(data.getSalary());
        emp.setCity(data.getCity());
        emp.setDepartment(data.getDepartment());
        return repo.save(emp);
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}


