package com.mongoDb.MongoDB.controller;

import com.mongoDb.MongoDB.model.Employee;
import com.mongoDb.MongoDB.model.request.EmployeeRequest;
import com.mongoDb.MongoDB.model.response.EmployeeResponse;
import com.mongoDb.MongoDB.repository.DepartmentRepository;
import com.mongoDb.MongoDB.service.EmployeeService;
import com.mongoDb.MongoDB.utility.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository ;

    @PostMapping("/save")
    public Employee addEmp(@RequestBody EmployeeRequest employee) {
        return employeeService.addEmp(employee);
    }

    @PostMapping("/upload")
    public ResponseEntity< List<Employee>> uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            Map<String,Employee> employees = ExcelHelper.convertExcelToList(file.getInputStream(), departmentRepository);

            List<Employee> empList = employeeService.saveAllEmp(employees);
            return ResponseEntity.ok(empList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


//    @GetMapping("GetById/{id}")
//    public EmployeeResponse getById(@PathVariable String id) {
//        return employeeService.getById(id);
//    }
//
    @PutMapping("Update/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable String id, @RequestBody EmployeeRequest employeeRequest) {
        try {
            EmployeeResponse updated = employeeService.updateEmployee(id, employeeRequest);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
//
    @DeleteMapping("Delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        String s = employeeService.deleteEmployee(id);
        return s ;
    }
}
