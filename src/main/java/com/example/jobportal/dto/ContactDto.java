package com.example.jobportal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    @NotBlank(message = "fullName cannot be empty")
    @Size(min = 2, max = 100, message = "fullName must be between 2 and 100 characters")
    private String fullName;

    @NotBlank(message = "email cannot be empty")
    @Email(message = "invalid email format")
    private String email;

    @NotBlank(message = "userType cannot be empty")
    @Pattern(
            regexp = "Job Seeker|Employer|Other",
            message = "userType must be Job Seeker, Employer, or Other"
    )
    private String userType;

    @NotBlank(message = "subject cannot be empty")
    @Size(min = 3, max = 150, message = "subject must be between 3 and 150 characters")
    private String subject;

    @NotBlank(message = "message cannot be empty")
    @Size(min = 10, max = 1000, message = "message must be between 10 and 1000 characters")
    private String message;
}