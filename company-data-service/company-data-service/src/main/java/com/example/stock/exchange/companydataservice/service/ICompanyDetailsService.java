package com.example.stock.exchange.companydataservice.service;

import com.example.stock.exchange.companydataservice.dto.CompanyDTO;
import com.example.stock.exchange.companydataservice.dto.IpoDetailsDTO;
import com.example.stock.exchange.companydataservice.model.Company;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface ICompanyDetailsService {
    public Iterable<CompanyDTO> getAllCompanies();
    public Optional<CompanyDTO> addCompany(CompanyDTO companyDTO);
    public Optional<CompanyDTO> getCompanyByCompanyCode(int companyCode);
    public List<CompanyDTO> getCompanyByRegex(String regex);
    public double getCompanyStockPrice(int companyCode, String from, String to) throws ParseException;
    public Optional<IpoDetailsDTO> getIpoDetails(String companyName);
}
