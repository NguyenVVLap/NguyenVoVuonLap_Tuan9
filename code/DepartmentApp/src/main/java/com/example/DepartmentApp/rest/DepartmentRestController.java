package com.example.DepartmentApp.rest;

import com.example.DepartmentApp.entity.Department;
import com.example.DepartmentApp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @Value("${welcome}")
    private String welcome;

    @GetMapping("/hello")
    public String hello() {
        return welcome;
    }
    @GetMapping("/departments")
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @PostMapping("/departments")
    public Department save(@RequestBody Department dep) {
        return departmentService.save(dep);
    }
}
