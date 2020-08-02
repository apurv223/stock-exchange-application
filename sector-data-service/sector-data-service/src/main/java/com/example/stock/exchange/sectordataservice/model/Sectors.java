package com.example.stock.exchange.sectordataservice.model;

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
public class Sectors {
    @Id
    @GeneratedValue
    private Long id;
    private int companyCode;
    private String sectorId;
    private String sector;

}
