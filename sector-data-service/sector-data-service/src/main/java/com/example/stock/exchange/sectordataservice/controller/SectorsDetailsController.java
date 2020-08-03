package com.example.stock.exchange.sectordataservice.controller;

import com.example.stock.exchange.sectordataservice.dto.CompanyDTO;
import com.example.stock.exchange.sectordataservice.service.ISectorsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SectorsDetailsController {
    @Autowired
    ISectorsDetailsService sectorsDetailsService;

    @RequestMapping("/sector/listCompanies/{sector}")
    public ResponseEntity<List<CompanyDTO>> getListOfCompaniesInSector(@PathVariable String sector){
        return ResponseEntity.status(HttpStatus.FOUND).body(sectorsDetailsService.getListOfCompaniesInSector(sector));
    }

    @RequestMapping("/sector/price/{sectorId}/from/{from}/to/{to}")
    public ResponseEntity<Double> getSectorPrice(@PathVariable String sectorId,@PathVariable String from,@PathVariable String to){
        return ResponseEntity.status(HttpStatus.FOUND).body(sectorsDetailsService.getSectorPrice(sectorId,from,to));
    }
}
