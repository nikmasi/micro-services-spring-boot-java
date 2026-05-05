package com.example.company;

import com.example.company.client.EmployeeClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final EmployeeClient employeeClient;

    public void saveCompany(Company company){
        companyRepository.save(company);
    }

    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }

    public FullCompanyResponse getAllCompanyWithEmployees(Integer companyId) {
        var company= companyRepository.findById(companyId).orElse(Company.builder().
                        name("NOT FOUND")
                        .email("NOT FOUND")
                        .build());
        var employees = employeeClient.findAllEmployeesBySchool(companyId);
        return FullCompanyResponse.builder()
                .name(company.getName())
                .email(company.getEmail())
                .employees(employees)
                .build();
    }
}
