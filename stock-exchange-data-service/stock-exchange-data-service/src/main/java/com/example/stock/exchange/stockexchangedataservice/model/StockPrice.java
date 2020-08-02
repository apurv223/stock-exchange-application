package com.example.stock.exchange.stockexchangedataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPrice {
    @Id
    @GeneratedValue
    private Long id;
    private int companyCode;
    private double price;
    private String stockExchange;
    private Date date;

}
