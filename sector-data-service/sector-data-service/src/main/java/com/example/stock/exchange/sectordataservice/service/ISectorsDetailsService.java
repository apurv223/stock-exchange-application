package com.example.stock.exchange.sectordataservice.service;

import com.example.stock.exchange.sectordataservice.dto.CompanyDTO;
import com.example.stock.exchange.sectordataservice.model.Sectors;

import java.util.List;

public interface ISectorsDetailsService {
    public List<CompanyDTO> getListOfCompaniesInSector(String sector);
    public double getSectorPrice(String sectorId, String from, String to);
}
