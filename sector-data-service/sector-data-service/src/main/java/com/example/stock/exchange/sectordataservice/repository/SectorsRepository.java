package com.example.stock.exchange.sectordataservice.repository;

import com.example.stock.exchange.sectordataservice.model.Company;
import com.example.stock.exchange.sectordataservice.model.Sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SectorsRepository extends JpaRepository<Sectors,Long> {
    public List<Sectors> getAllBySectorId(String sectorId);

}
