package com.example.stock.exchange.companydataservice.repository;

import com.example.stock.exchange.companydataservice.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;

import java.sql.Date;
import java.util.List;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice,Long> {
    public List<StockPrice> findAllByCompanyCodeAndDateBetween(int companyCode, Date from, Date to);
}
