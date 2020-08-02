package com.example.stock.exchange.stockexchangedataservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
