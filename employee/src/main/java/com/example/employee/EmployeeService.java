package com.example.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployee(Integer id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByCompany(Integer companyId) {
        return employeeRepository.findAllByCompanyId(companyId);
    }
}
