package com.example.company.client;

import com.example.company.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service", url = "${application.config.employees-url}")
public interface EmployeeClient {

    @GetMapping("/company/{company-id}")
    List<Employee> findAllEmployeesBySchool(@PathVariable("company-id") Integer companyId);
}
