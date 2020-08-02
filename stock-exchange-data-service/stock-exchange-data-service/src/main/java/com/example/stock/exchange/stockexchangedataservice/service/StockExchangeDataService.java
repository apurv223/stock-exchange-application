package com.example.stock.exchange.stockexchangedataservice.service;

import com.example.stock.exchange.stockexchangedataservice.dto.CompanyDTO;
import com.example.stock.exchange.stockexchangedataservice.dto.StockExchangeDTO;
import com.example.stock.exchange.stockexchangedataservice.model.IpoDetails;
import com.example.stock.exchange.stockexchangedataservice.model.StockExchange;
import com.example.stock.exchange.stockexchangedataservice.repository.IpoDetailsRepository;
import com.example.stock.exchange.stockexchangedataservice.repository.StockExchangeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockExchangeDataService implements IStockExchangeDataService {
    @Autowired
    StockExchangeRepository stockExchangeRepository;
    @Autowired
    IpoDetailsRepository ipoDetailsRepository;

    @Override
    @Transactional
    public List<StockExchangeDTO> getAllStockExchange() {

       List<StockExchange> stockExchanges = stockExchangeRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<Iterable<StockExchangeDTO>>(){}.getType();
        List<StockExchangeDTO> postDtoList = modelMapper.map(stockExchanges,listType);
        return postDtoList;
    }

    @Override
    @Transactional
    public StockExchangeDTO addStockExchange(StockExchangeDTO stockExchangeDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StockExchange stockExchange = new StockExchange();
        modelMapper.map(stockExchangeDTO,stockExchange);
        return stockExchangeDTO;
    }

    @Override
    public List<String> getCompaniesByExchange(String stockExchange) {
        List<IpoDetails> list = ipoDetailsRepository.getAllByStockExchange(stockExchange);
        List<String> arrayList = new ArrayList<>(){};
        for (IpoDetails ipoDetails:
             list) {
            arrayList.add(ipoDetails.getCompanyName());
        }
        return arrayList;
    }
}
