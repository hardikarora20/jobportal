package com.example.jobportal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private String fullName;
    private String email;
    private String userType;   // Job Seeker | Employer | Other
    private String subject;
    private String message;
}
