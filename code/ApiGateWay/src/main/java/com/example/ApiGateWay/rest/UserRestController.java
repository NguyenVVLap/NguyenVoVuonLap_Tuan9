package com.example.ApiGateWay.rest;

import com.example.ApiGateWay.model.Department;
import com.example.ApiGateWay.model.User;
import com.example.ApiGateWay.service.DepartmentService;
import com.example.ApiGateWay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/users")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/departments")
    public List<Department> getAllDep() {
        return departmentService.getAll();
    }

    @PostMapping("/departments")
    public Department save(@RequestBody Department dep) {
        return departmentService.save(dep);
    }
}
