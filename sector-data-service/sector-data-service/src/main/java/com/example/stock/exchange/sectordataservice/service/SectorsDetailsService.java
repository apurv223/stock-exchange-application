package com.example.stock.exchange.sectordataservice.service;

import com.example.stock.exchange.sectordataservice.dto.CompanyDTO;
import com.example.stock.exchange.sectordataservice.model.Company;
import com.example.stock.exchange.sectordataservice.model.Sectors;
import com.example.stock.exchange.sectordataservice.model.StockPrice;
import com.example.stock.exchange.sectordataservice.repository.CompanyRepository;
import com.example.stock.exchange.sectordataservice.repository.SectorsRepository;
import com.example.stock.exchange.sectordataservice.repository.StockPriceRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class SectorsDetailsService implements ISectorsDetailsService {
    @Autowired
    SectorsRepository sectorsRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    StockPriceRepository stockPriceRepository;

    @Override
    @Transactional
    public List<CompanyDTO> getListOfCompaniesInSector(String sector){
        List<Company> companyList = companyRepository.getAllBySector(sector);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<Iterable<CompanyDTO>>(){}.getType();
        List<CompanyDTO> postDtoList = modelMapper.map(companyList,listType);
        return postDtoList;
    }

    @Override
    @Transactional
    public double getSectorPrice(String sectorId, String from, String to){
        List<Sectors> list = sectorsRepository.getAllBySectorId(sectorId);
        String sectorName= list.get(0).getSector();
        // now finding all companies within the sector
        List<Company> companyList = companyRepository.getAllBySector(sectorName);
        List<Integer> companyCodeList =new ArrayList<>(){};
        for (Company company:companyList) {
            companyCodeList.add(company.getCompanyCode());
        }
        List<StockPrice> stockPrices = stockPriceRepository.getAll(companyCodeList, Date.valueOf(from), Date.valueOf(to));
        //Remove by feign client
        double x = 0.0;
        for(int i=0;i<stockPrices.size();i++)
        {
            x = x + stockPrices.get(i).getPrice();
        }
        x = x / stockPrices.size();
        return x;
    }
}
