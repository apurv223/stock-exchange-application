package com.example.stock.exchange.sectordataservice.repository;

import com.example.stock.exchange.sectordataservice.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface StockPriceRepository extends JpaRepository<StockPrice,Long> {
    @Query(value = "SELECT * FROM STOCK_PRICE s WHERE s.company_code IN (:companyCode) AND s.date BETWEEN (:fromDate) AND (:toDate)",
            nativeQuery = true)
    public List<StockPrice> getAll(@Param("companyCode")List<Integer> companyCode, @Param("fromDate")Date fromDate,@Param("toDate")Date toDate);
}
