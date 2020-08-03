package com.example.stock.exchange.sectordataservice;

import com.example.stock.exchange.sectordataservice.dto.CompanyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface ProxySectorDataService {
    @RequestMapping("/sector/listCompanies/{sector}")
    public ResponseEntity<List<CompanyDTO>> getListOfCompaniesInSector(@PathVariable(value = "sector") String sector);

    @RequestMapping("/sector/price/{sectorId}/from/{from}/to/{to}")
    public ResponseEntity<Double> getSectorPrice(@PathVariable(value = "sectorId") String sectorId,@PathVariable(value = "from") String from,@PathVariable(value = "to") String to);
}
