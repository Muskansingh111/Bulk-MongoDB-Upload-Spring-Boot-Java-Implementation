package com.mongoDb.MongoDB.model.request;

import com.mongoDb.MongoDB.model.Address;
import com.mongoDb.MongoDB.model.Department;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    @NotBlank(message = "Name must not be BLANK")
    private String name;
    private List<Address> address;
    private String departmentId;
}
