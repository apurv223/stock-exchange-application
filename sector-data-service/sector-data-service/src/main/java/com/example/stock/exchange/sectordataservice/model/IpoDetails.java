package com.example.stock.exchange.sectordataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpoDetails {
    @Id
    @GeneratedValue
    private Long id;
	private String companyName;
    private String stockExchange;
	private double pricePerShare;
	private int totalNumberOfShares;
	private Date openDateTime;
	private String Remarks;

}
