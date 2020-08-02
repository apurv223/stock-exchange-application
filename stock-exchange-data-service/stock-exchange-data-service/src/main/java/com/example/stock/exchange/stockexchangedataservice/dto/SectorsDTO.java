package com.example.stock.exchange.stockexchangedataservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectorsDTO {

    private int companyCode;
    private String sectorId;
    private String sector;

}
