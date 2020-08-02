package com.example.stock.exchange.companydataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
