package com.example.UserApp.service;

import com.example.UserApp.entity.User;
import com.example.UserApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    private RestTemplate restTemplate;
    private String BASEURL = "http://localhost:8002";

    public UserServiceImpl() {
        this.restTemplate = new RestTemplate();
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Object> getAllDeparment() {
        return restTemplate.getForObject(BASEURL + "/departments", ArrayList.class);
    }
}
