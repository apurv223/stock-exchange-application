package com.example.stock.exchange.stockexchangedataservice.repository;

import com.example.stock.exchange.stockexchangedataservice.model.IpoDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IpoDetailsRepository extends JpaRepository<IpoDetails,Long> {
    public List<IpoDetails> getAllByStockExchange(String stockExchange);
}
