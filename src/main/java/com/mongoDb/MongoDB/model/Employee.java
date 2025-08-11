package com.mongoDb.MongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    private String id;

    private String name;

    private String MobileNo ;

    private List<Address> address; // Embedded

    @DBRef
  private Department department ;
}
