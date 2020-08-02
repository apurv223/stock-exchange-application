package com.example.stock.exchange.stockexchangedataservice.service;

import com.example.stock.exchange.stockexchangedataservice.dto.StockExchangeDTO;

import java.util.List;

public interface IStockExchangeDataService {
    public List<StockExchangeDTO> getAllStockExchange();
    public StockExchangeDTO addStockExchange(StockExchangeDTO stockExchangeDTO);
    public List<String> getCompaniesByExchange(String stockExchange);
}
