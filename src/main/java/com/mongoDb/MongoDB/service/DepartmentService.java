package com.mongoDb.MongoDB.service;

import com.mongoDb.MongoDB.model.Department;
import com.mongoDb.MongoDB.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(String id, Department updatedDepartment) {
        Department existing = departmentRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedDepartment.getName());
            return departmentRepository.save(existing);
        }
        return null;
    }
}
