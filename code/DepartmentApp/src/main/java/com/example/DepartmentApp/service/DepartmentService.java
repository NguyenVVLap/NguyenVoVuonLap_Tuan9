package com.example.DepartmentApp.service;

import com.example.DepartmentApp.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAll();
    public Department save(Department dep);
}
