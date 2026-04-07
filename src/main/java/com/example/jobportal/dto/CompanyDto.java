package com.example.jobportal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private Integer id;
    private String companyName;
    private String email;
    private String phone;
    private String industry;
    private String website;
    private String address;
    private String description;
}