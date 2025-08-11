package com.mongoDb.MongoDB.model.response;

import com.mongoDb.MongoDB.model.Address;
import com.mongoDb.MongoDB.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponse {

    private String id;

    private String name;

    private Address address;

    private String departmentName ;
}
