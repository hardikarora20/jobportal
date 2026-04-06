package com.example.jobportal.controller;

import com.example.jobportal.dto.CompanyDto;
import com.example.jobportal.entity.Company;
import com.example.jobportal.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins = "http://localhost:5500")
public class MainController {

    CompanyService companyService;

    public MainController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> hello(@PathVariable String name){
//        return "hello " + name;
        return ResponseEntity.status(201).body("hello human, " + name);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){
        return ResponseEntity.status(200).body(companyService.getAllCompanies());
    }
}
