package com.example.demo.Service;


import com.example.demo.Entity.Department;
import com.example.demo.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    public Department getDepartmentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department addDepartment(Department dept) {
        return repo.save(dept);
    }

    public Department updateDepartment(Long id, Department data) {
        Department dept = getDepartmentById(id);
        dept.setDeptName(data.getDeptName());
        return repo.save(dept);
    }

    public void deleteDepartment(Long id) {
        repo.deleteById(id);
    }
}

