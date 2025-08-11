package com.mongoDb.MongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private Boolean isCurrent ;
}

