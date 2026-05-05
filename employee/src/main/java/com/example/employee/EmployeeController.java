package com.example.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(
            @RequestBody Employee employee
    ){
        employeeService.saveEmployee(employee);
    }

    @GetMapping("/company/{company-id}")
    public List<Employee> getEmployeesByCompany(
            @PathVariable("company-id") Integer companyId
    ){
        return employeeService.getEmployeesByCompany(companyId);
    }
}
