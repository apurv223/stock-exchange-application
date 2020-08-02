package com.example.stock.exchange.companydataservice.service;

import com.example.stock.exchange.companydataservice.dto.CompanyDTO;
import com.example.stock.exchange.companydataservice.dto.IpoDetailsDTO;
import com.example.stock.exchange.companydataservice.model.Company;
import com.example.stock.exchange.companydataservice.model.IpoDetails;
import com.example.stock.exchange.companydataservice.model.StockPrice;
import com.example.stock.exchange.companydataservice.repository.CompanyRepository;
import com.example.stock.exchange.companydataservice.repository.IpoDetailsRepository;
import com.example.stock.exchange.companydataservice.repository.StockPriceRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@EnableTransactionManagement
public class CompanyDetailsService implements ICompanyDetailsService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    StockPriceRepository stockPriceRepository;
    @Autowired
    IpoDetailsRepository ipoDetailsRepository;

    @Override
    @Transactional
    public Iterable<CompanyDTO> getAllCompanies()
    {
        List<Company> companyList = companyRepository.findAll();
        /*  if(userEntity==null)
        {
            throw new UserNotFoundException("user not found with the user id: "+userId);
        }*/
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<Iterable<CompanyDTO>>(){}.getType();
        Iterable<CompanyDTO> postDtoList = modelMapper.map(companyList,listType);
        return postDtoList;
    }

    @Override
    @Transactional
    public Optional<CompanyDTO> addCompany(CompanyDTO companyDTO){
        Company company = new Company();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(companyDTO,company);
        companyRepository.save(company);
        return Optional.of(companyDTO);
    }

    @Override
    @Transactional
    public Optional<CompanyDTO> getCompanyByCompanyCode(int companyCode)
    {
        Company company = companyRepository.findByCompanyCode(companyCode);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompanyDTO companyDTO = new CompanyDTO();
        modelMapper.map(company,companyDTO);
        return Optional.of(companyDTO);
    }

    @Override
    @Transactional
    public List<CompanyDTO> getCompanyByRegex(String regex)
    {
        List<Company> companyList  = companyRepository.findByCompanyNameContaining(regex);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<Iterable<CompanyDTO>>(){}.getType();
        List<CompanyDTO> postDtoList = modelMapper.map(companyList,listType);
        return postDtoList;
    }

    @Override
    @Transactional
    public double getCompanyStockPrice(int companyCode, String from, String to) throws ParseException {
        List<StockPrice> list = stockPriceRepository.findAllByCompanyCodeAndDateBetween(companyCode, Date.valueOf(from),Date.valueOf(to));
        //Assuming average stock price between days
        double x = 0.0;
        for(int i=0;i<list.size();i++)
        {
            x = x + list.get(i).getPrice();
        }
        x = x / list.size();
        return x;
    }


    @Override
    @Transactional
    public Optional<IpoDetailsDTO> getIpoDetails(String companyName)
    {
        IpoDetails ipoDetails = ipoDetailsRepository.findByCompanyName(companyName);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        IpoDetailsDTO ipoDetailsDTO = new IpoDetailsDTO();
        modelMapper.map(ipoDetails,ipoDetailsDTO);
        return Optional.of(ipoDetailsDTO);
    }
}
