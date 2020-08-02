package com.example.stock.exchange.stockexchangedataservice.repository;

import com.example.stock.exchange.stockexchangedataservice.model.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange,Long> {

}
