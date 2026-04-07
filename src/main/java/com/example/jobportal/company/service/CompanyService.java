package com.example.jobportal.company.service;

import com.example.jobportal.company.service.ICompanyService;
import com.example.jobportal.dto.CompanyDto;
import com.example.jobportal.entity.Company;
import com.example.jobportal.repository.CompanyRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService implements ICompanyService {
    CompanyRespository companyRepository;

    public CompanyService(CompanyRespository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyDto> getAllCompanies(){
        List <Company> allCompanies = companyRepository.findAll();
        List <CompanyDto> companyData = allCompanies.stream().map(this::transformCompanytoCompanyDto).collect(Collectors.toList());
        return companyData;
    }

    private CompanyDto transformCompanytoCompanyDto(Company company){
        return new CompanyDto(company.getId(), company.getCompanyName(), company.getEmail(), company.getPhone(), company.getIndustry(), company.getWebsite(), company.getAddress(), company.getDescription());
    }
}
