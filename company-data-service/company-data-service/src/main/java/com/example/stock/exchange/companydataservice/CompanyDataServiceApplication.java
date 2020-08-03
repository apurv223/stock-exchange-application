package com.example.stock.exchange.companydataservice;

import brave.sampler.Sampler;
import com.example.stock.exchange.companydataservice.model.Company;
import com.example.stock.exchange.companydataservice.model.IpoDetails;
import com.example.stock.exchange.companydataservice.model.StockPrice;
import com.example.stock.exchange.companydataservice.repository.CompanyRepository;
import com.example.stock.exchange.companydataservice.repository.IpoDetailsRepository;
import com.example.stock.exchange.companydataservice.repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients("com.example.stock.exchange.companydataservice")
@EnableDiscoveryClient
public class CompanyDataServiceApplication implements CommandLineRunner {

	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	StockPriceRepository stockPriceRepository;
	@Autowired
	IpoDetailsRepository ipoDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(CompanyDataServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//storing company
		companyRepository.save(new Company(Long.getLong("1"),103,"SBI",45621,"Apurv","a,b,c,d","Banking","Best bank","SBIIN"));
		companyRepository.save(new Company(Long.getLong("2"),104,"SBC",45233,"Sumit","a,b,c,d","Entertainment","Best show buz","SBCIN"));
		//storing stock price
		//query url:-> http://localhost:8080/company/stock/103/2020-01-04/2020-01-06
		stockPriceRepository.save(new StockPrice(Long.getLong("1"),103,456.2,"NSE",Date.valueOf("2020-01-04")));
		stockPriceRepository.save(new StockPrice(Long.getLong("2"),103,456.2,"NSE",Date.valueOf("2020-01-05")));
		stockPriceRepository.save(new StockPrice(Long.getLong("3"),103,456.2,"NSE",Date.valueOf("2020-01-06")));
		//storing ipodetails
		//query url:-> http://localhost:8080/company/ipo/SBI
		ipoDetailsRepository.save(new IpoDetails(Long.getLong("1"),"SBI","NSE",456.3,456789,Date.valueOf("2020-01-04"),"Great growth"));
		ipoDetailsRepository.save(new IpoDetails(Long.getLong("1"),"SBC","NSE",456.3,456789,Date.valueOf("2020-01-04"),"Great growth"));
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
