package com.example.UserApp.service;

import com.example.UserApp.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User save(User user);
}
