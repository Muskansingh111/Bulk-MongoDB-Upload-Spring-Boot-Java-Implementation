package com.mongoDb.MongoDB.repository;

import com.mongoDb.MongoDB.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department,String> {
     public Department findByName(String name);
}
