package com.mongoDb.MongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "department")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @Id
    private String id;

    private String name;
}
