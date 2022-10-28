package com.example.ApiGateWay.service;

import com.example.ApiGateWay.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User save(User user);
}
