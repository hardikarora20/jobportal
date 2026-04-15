package com.example.jobportal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name", nullable = false, length = 100)
    private String companyName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String industry;

    @Column(length = 150)
    private String website;

    @Column(length = 255)
    private String address;

    @Column(length = 500)
    private String description;

    @Column(length = 20)
    private String role = "COMPANY";

    public Company(String companyName, String email, String password, String phone,
                   String industry, String website, String address, String description) {
        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.industry = industry;
        this.website = website;
        this.address = address;
        this.description = description;
    }
}