package com.example.stock.exchange.stockexchangedataservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private int companyCode;
    private String companyName;
	private long turnover;
	private String ceo;
	private String boardOfDirectors;
	private String sector;
	private String briefWriteup;
	private String stockCode;
    // Listed in Stock Exchanges
}
