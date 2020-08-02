package com.example.stock.exchange.companydataservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPriceDTO {

    private int companyCode;
    private double price;
    private String stockExchange;
    @Temporal(TemporalType.DATE)
    private Date date;
}
