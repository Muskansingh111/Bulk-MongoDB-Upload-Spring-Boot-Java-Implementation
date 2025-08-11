package com.mongoDb.MongoDB.service;

import com.mongoDb.MongoDB.model.Address;
import com.mongoDb.MongoDB.model.Department;
import com.mongoDb.MongoDB.model.Employee;
import com.mongoDb.MongoDB.repository.DepartmentRepository;
import com.mongoDb.MongoDB.repository.EmployeeRepository;

import com.mongoDb.MongoDB.model.request.EmployeeRequest;
import com.mongoDb.MongoDB.model.response.EmployeeResponse;
import com.mongoDb.MongoDB.utility.EmployeeHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    //save
    public Employee addEmp(EmployeeRequest req) {
        Optional<Department> department = departmentRepository.findById(req.getDepartmentId());

        Employee emp = new Employee();
        emp.setName(req.getName());
        emp.setDepartment(department.get());
        emp.setAddress(req.getAddress());
        Employee save = employeeRepository.save(emp);

        return save;
    }

    /// Read
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    // Read By ID
    public EmployeeResponse getById(String id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeResponse res = EmployeeHelper.objToResponse(employee);
        return res;
    }

    //UPDATE
    public EmployeeResponse updateEmployee(String id, EmployeeRequest updateRequest) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee existingEmployee = optionalEmployee.get();

        if (optionalEmployee.isPresent()) {
            //  Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(updateRequest.getName());
            String departmentId = updateRequest.getDepartmentId();

            Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
            if (optionalDepartment.isPresent()) {
                Department existingDepartment = optionalDepartment.get();
                existingEmployee.setDepartment(existingDepartment);
            }
            existingEmployee.setAddress(updateRequest.getAddress());
        }
        Employee save = employeeRepository.save(existingEmployee);
        EmployeeResponse res = EmployeeHelper.objToResponse(save);
        return res;
    }

    //Delete
    public String deleteEmployee(String id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if (byId.isPresent()) {
            employeeRepository.deleteById(id);
            return "Deleted successfully";
        } else {
            return "Employee with this Id doesn't exist = " + id;
        }

    }

    public List<Employee> saveAllEmp(Map<String,Employee> employees) {
        Collection<Employee> values = employees.values();
        List<Employee> empLst = employeeRepository.saveAll(values);
        return empLst;
    }


}