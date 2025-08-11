package com.mongoDb.MongoDB.utility;

import com.mongoDb.MongoDB.model.Address;
import com.mongoDb.MongoDB.model.Department;
import com.mongoDb.MongoDB.model.Employee;
import com.mongoDb.MongoDB.repository.DepartmentRepository;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.*;

public class ExcelHelper {

    public static Map<String, Employee> convertExcelToList(InputStream is, DepartmentRepository departmentRepository) {
        Map<String, Employee> map = new LinkedHashMap<>();

        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;


                String name = row.getCell(0).getStringCellValue();

                String mobile;
                if (row.getCell(7).getCellType() == CellType.STRING) {
                    mobile = row.getCell(7).getStringCellValue();
                } else {
                    mobile = String.valueOf((long) row.getCell(7).getNumericCellValue());
                }

                String key = name + mobile;

                Address address = new Address();
                address.setStreet(row.getCell(1).getStringCellValue());
                address.setCity(row.getCell(2).getStringCellValue());
                address.setState(row.getCell(3).getStringCellValue());
                address.setZip(String.valueOf((long) row.getCell(4).getNumericCellValue()));
              int  isCurrent = ((int) row.getCell(5).getNumericCellValue());
              if(isCurrent == 1){
                  address.setIsCurrent(true);
              }
               else{
                  address.setIsCurrent(false);
              }

                if (!map.containsKey(key)) {

                    Employee emp = new Employee();
                    emp.setName(name);
                    emp.setMobileNo(mobile);

                    Department dept = departmentRepository.findByName(row.getCell(6).getStringCellValue());
                    emp.setDepartment(dept);

                    List<Address> addresses = new ArrayList<>();
                    addresses.add(address);
                    emp.setAddress(addresses);

                    map.put(key, emp);
                } else {

                    Employee existingEmp = map.get(key);
                    existingEmp.getAddress().add(address);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
        }
        return map;
    }
}

