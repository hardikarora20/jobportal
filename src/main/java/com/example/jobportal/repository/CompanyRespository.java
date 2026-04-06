package com.example.jobportal.repository;

import com.example.jobportal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRespository extends JpaRepository <Company, Long> {

}
