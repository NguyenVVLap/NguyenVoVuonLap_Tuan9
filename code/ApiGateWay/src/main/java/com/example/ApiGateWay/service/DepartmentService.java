package com.example.ApiGateWay.service;

import com.example.ApiGateWay.model.Department;
import com.example.ApiGateWay.model.User;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAll();
    public Department save(Department department);
}
