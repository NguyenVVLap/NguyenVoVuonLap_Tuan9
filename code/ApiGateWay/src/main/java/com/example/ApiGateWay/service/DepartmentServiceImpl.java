package com.example.ApiGateWay.service;

import com.example.ApiGateWay.model.Department;
import com.example.ApiGateWay.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private RestTemplate restTemplate;
    //    private String crmRestUrl = "http://host.docker.internal:8080/books";
    private String crmRestUrl = "http://localhost:8002/departments";
    public DepartmentServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Department save(Department dep) {
        restTemplate.postForObject(crmRestUrl, dep, String.class);
        return dep;
    }

    @Override
    public List<Department> getAll() {
        ResponseEntity<List<Department>> responseEntity =
                restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Department>>() {});
        List<Department> deps = responseEntity.getBody();
        return deps;
    }
}
