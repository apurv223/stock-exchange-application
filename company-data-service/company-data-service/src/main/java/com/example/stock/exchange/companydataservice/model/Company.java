package com.example.stock.exchange.companydataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
	@GeneratedValue
	private Long id;
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
