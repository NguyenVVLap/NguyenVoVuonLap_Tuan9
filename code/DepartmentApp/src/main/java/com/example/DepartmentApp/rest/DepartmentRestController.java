package com.example.DepartmentApp.rest;

import com.example.DepartmentApp.entity.Department;
import com.example.DepartmentApp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @PostMapping("/departments")
    public Department save(@RequestBody Department dep) {
        return departmentService.save(dep);
    }
}
