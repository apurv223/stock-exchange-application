package com.example.stock.exchange.companydataservice.repository;

import com.example.stock.exchange.companydataservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    public Company findByCompanyCode(int companyCode);
    public List<Company> findByCompanyNameContaining(String regex);
}
