package com.mongoDb.MongoDB.utility;

import com.mongoDb.MongoDB.model.Address;
import com.mongoDb.MongoDB.model.Department;
import com.mongoDb.MongoDB.model.Employee;
import com.mongoDb.MongoDB.model.response.EmployeeResponse;

import java.util.List;

public class EmployeeHelper {


    public static EmployeeResponse objToResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        List<Address> addressList = employee.getAddress();
        for (Address add : addressList) {
            if (add.getIsCurrent()) {
                response.setAddress(add);
            }
        }
        Department department = employee.getDepartment();
//        department.getName() ;
        response.setDepartmentName(department.getName());
        response.setName(employee.getName());
        response.setId(employee.getId());
        return response;
    }


}
