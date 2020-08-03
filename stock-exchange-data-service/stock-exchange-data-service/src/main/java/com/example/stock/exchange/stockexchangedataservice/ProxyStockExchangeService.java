package com.example.stock.exchange.stockexchangedataservice;


import com.example.stock.exchange.stockexchangedataservice.dto.StockExchangeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface ProxyStockExchangeService {

    @RequestMapping(value = "/exchange/all",method = RequestMethod.GET)
    public ResponseEntity<Iterable<StockExchangeDTO>> getStockExchangeList();

    @RequestMapping(value = "/exchange/add",method = RequestMethod.POST)
    public ResponseEntity<StockExchangeDTO> addStockExchangeList(@RequestBody StockExchangeDTO stockExchangeDTO);

    @RequestMapping(value = "/exchange/{stockExchange}/companies",method = RequestMethod.GET)
    public ResponseEntity<Iterable<String>> getCompaniesByExchange(@PathVariable(value = "stockExchange") String stockExchange);
}
