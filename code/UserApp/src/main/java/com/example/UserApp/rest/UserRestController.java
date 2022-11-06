package com.example.UserApp.rest;

import com.example.UserApp.entity.User;
import com.example.UserApp.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

//    @Value("${welcome}")
    private String welcome;

    @GetMapping("/hello")
    public String hello() {
        return welcome;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/getAllDepartment")
    @CircuitBreaker(name ="userService")
    public List<Object> getAllDeparment() {
        return userService.getAllDeparment();
    }

//    public String informFall(Exception e) {
//        return "Fail to get departments";
//    }

    @PostMapping("/users")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}
