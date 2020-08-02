package com.example.stock.exchange.companydataservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpoDetailsDTO {

	private String companyName;
    private String stockExchange;
	private double pricePerShare;
	private int totalNumberOfShares;
	private Date openDateTime;
	private String Remarks;

}
