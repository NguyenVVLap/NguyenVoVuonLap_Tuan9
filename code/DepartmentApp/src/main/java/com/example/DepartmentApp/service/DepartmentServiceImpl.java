package com.example.DepartmentApp.service;

import com.example.DepartmentApp.entity.Department;
import com.example.DepartmentApp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department save(Department dep) {
        return departmentRepository.save(dep);
    }
}
