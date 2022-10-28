package com.example.ApiGateWay.service;

import com.example.ApiGateWay.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private RestTemplate restTemplate;
    //    private String crmRestUrl = "http://host.docker.internal:8080/books";
    private String crmRestUrl = "http://localhost:8001/users";
    public UserServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public User save(User user) {
        restTemplate.postForObject(crmRestUrl, user, String.class);
        return user;
    }

    @Override
    public List<User> getAll() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<User>>() {});
        List<User> users = responseEntity.getBody();
        return users;
    }
}
