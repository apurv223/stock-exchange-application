package com.example.stock.exchange.stockexchangedataservice.repository;

import com.example.stock.exchange.stockexchangedataservice.model.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface StockExchangeRepository extends JpaRepository<StockExchange,Long> {

}
