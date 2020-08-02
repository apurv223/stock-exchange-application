package com.example.stock.exchange.stockexchangedataservice.controller;

import com.example.stock.exchange.stockexchangedataservice.dto.StockExchangeDTO;
import com.example.stock.exchange.stockexchangedataservice.model.StockExchange;
import com.example.stock.exchange.stockexchangedataservice.service.IStockExchangeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StockExchangeDataController {

    @Autowired
    IStockExchangeDataService stockExchangeDataService;

    @RequestMapping(value = "/exchange/all",method = RequestMethod.GET)
    public ResponseEntity<Iterable<StockExchangeDTO>> getStockExchangeList(){
        return ResponseEntity.status(HttpStatus.FOUND).body(stockExchangeDataService.getAllStockExchange());
    }

    @RequestMapping(value = "/exchange/add",method = RequestMethod.POST)
    public ResponseEntity<StockExchangeDTO> addStockExchangeList(@RequestBody StockExchangeDTO stockExchangeDTO){
        return ResponseEntity.status(HttpStatus.FOUND).body(stockExchangeDataService.addStockExchange(stockExchangeDTO));
    }

    @RequestMapping(value = "/exchange/{stockExchange}/companies",method = RequestMethod.GET)
    public ResponseEntity<Iterable<String>> getCompaniesByExchange(@PathVariable String stockExchange){
        return ResponseEntity.status(HttpStatus.FOUND).body(stockExchangeDataService.getCompaniesByExchange(stockExchange));
    }

}
