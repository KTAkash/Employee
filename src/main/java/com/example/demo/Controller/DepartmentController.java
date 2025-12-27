package com.example.demo.Controller;

import com.example.demo.Entity.Department;
import com.example.demo.Service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Departments", description = "Department Management APIs")
@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @Operation(summary = "Get all departments")
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }

    @Operation(summary = "Get department by ID")
    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return service.getDepartmentById(id);
    }

    @Operation(summary = "Add a new department")
    @PostMapping("/department")
    public Department addDepartment(@RequestBody Department department) {
        return service.addDepartment(department);
    }

    @Operation(summary = "Update a department")
    @PutMapping("/department/{id}")
    public Department updateDepartment(
            @PathVariable Long id,
            @RequestBody Department department) {
        return service.updateDepartment(id, department);
    }

    @Operation(summary = "Delete a department")
    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        service.deleteDepartment(id);
        return "Department deleted successfully";
    }
}
