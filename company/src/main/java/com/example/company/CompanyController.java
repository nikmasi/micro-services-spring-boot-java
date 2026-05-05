package com.example.company;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCompany(
            @RequestBody Company company
    ){
        companyService.saveCompany(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        return ResponseEntity.ok(companyService.getAllCompany());
    }

    @GetMapping("/with-employees/{company-id}")
    public ResponseEntity<FullCompanyResponse> getAllCompany(
            @PathVariable("company-id") Integer companyId
    ){
        return ResponseEntity.ok(companyService.getAllCompanyWithEmployees(companyId));
    }
}