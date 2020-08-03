package com.example.stock.exchange.companydataservice.controller;

import com.example.stock.exchange.companydataservice.dto.CompanyDTO;
import com.example.stock.exchange.companydataservice.dto.IpoDetailsDTO;
import com.example.stock.exchange.companydataservice.model.Company;
import com.example.stock.exchange.companydataservice.service.ICompanyDetailsService;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class CompanyDetailsController {

    @Autowired
    ICompanyDetailsService companyDetailsService;

    @RequestMapping(value = "/company/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<CompanyDTO>> getAllCompanyDetails()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(companyDetailsService.getAllCompanies());
    }

    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public ResponseEntity<Optional<CompanyDTO>> addCompany(@RequestBody CompanyDTO companyDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyDetailsService.addCompany(companyDTO));
    }

    @RequestMapping(value = "/company/companyCode/{companyCode}", method = RequestMethod.GET)
    public ResponseEntity<Optional<CompanyDTO>> getCompanyByCompanyCode(@PathVariable int companyCode){
        return ResponseEntity.status(HttpStatus.FOUND).body(companyDetailsService.getCompanyByCompanyCode(companyCode));
    }

    @RequestMapping(value = "/company/regex/{regex}", method = RequestMethod.GET)
    public ResponseEntity<List<CompanyDTO>> getCompanyByRegex(@PathVariable String regex){
        return ResponseEntity.status(HttpStatus.FOUND).body(companyDetailsService.getCompanyByRegex(regex));
    }

    @RequestMapping(value = "/company/stock/{companyCode}/{from}/{to}")
    public ResponseEntity<Double> getCompanyStockPrice(@PathVariable int companyCode,@PathVariable String from,@PathVariable String to) throws ParseException {
        return ResponseEntity.status(HttpStatus.FOUND).body(companyDetailsService.getCompanyStockPrice(companyCode,from,to));
    }

    @RequestMapping(value = "/company/ipo/{companyName}")
    public ResponseEntity<Optional<IpoDetailsDTO>> getIpoDetails(@PathVariable String companyName)
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(companyDetailsService.getIpoDetails(companyName));
    }

}
