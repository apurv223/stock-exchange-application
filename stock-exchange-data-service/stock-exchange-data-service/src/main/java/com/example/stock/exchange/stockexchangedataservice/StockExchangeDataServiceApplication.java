package com.example.stock.exchange.stockexchangedataservice;

import brave.sampler.Sampler;
import com.example.stock.exchange.stockexchangedataservice.model.IpoDetails;
import com.example.stock.exchange.stockexchangedataservice.model.StockExchange;
import com.example.stock.exchange.stockexchangedataservice.repository.IpoDetailsRepository;
import com.example.stock.exchange.stockexchangedataservice.repository.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication

@EnableFeignClients("com.example.stock.exchange.stockexchangedataservice")
@EnableDiscoveryClient
public class StockExchangeDataServiceApplication implements CommandLineRunner {

	@Autowired
	IpoDetailsRepository ipoDetailsRepository;
	@Autowired
	StockExchangeRepository stockExchangeRepository;

	public static void main(String[] args) {
		SpringApplication.run(StockExchangeDataServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//storing ipodetails
		ipoDetailsRepository.save(new IpoDetails(Long.getLong("1"),"SBI","NSE",456.3,456789, Date.valueOf("2020-01-04"),"Great growth"));
		ipoDetailsRepository.save(new IpoDetails(Long.getLong("2"),"SBC","NSE",456.3,456789,Date.valueOf("2020-01-04"),"Great growth"));

		//storing stock exchange
		stockExchangeRepository.save(new StockExchange(Long.getLong("1"),"NSE"));
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
