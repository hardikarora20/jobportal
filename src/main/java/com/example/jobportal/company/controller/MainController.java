package com.example.jobportal.company.controller;

import com.example.jobportal.dto.CompanyDto;
import com.example.jobportal.company.service.CompanyService;
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
    public ResponseEntity<String> hello(@PathVariable String name) throws Exception {
//        return "hello " + name;
        return ResponseEntity.status(201).body("hello human, " + name);
//        to test exception handling
//        throw new Exception("tried throwing exception");
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){
        return ResponseEntity.status(200).body(companyService.getAllCompanies());
    }

//    if the same method for handling exception is defined here
//    then it won't go to the globalexceptionhandler
//    as it works with the nearest matching method

}