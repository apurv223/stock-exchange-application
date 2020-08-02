package com.example.stock.exchange.sectordataservice;

import com.example.stock.exchange.sectordataservice.model.Company;
import com.example.stock.exchange.sectordataservice.model.IpoDetails;
import com.example.stock.exchange.sectordataservice.model.Sectors;
import com.example.stock.exchange.sectordataservice.model.StockPrice;
import com.example.stock.exchange.sectordataservice.repository.CompanyRepository;
import com.example.stock.exchange.sectordataservice.repository.SectorsRepository;
import com.example.stock.exchange.sectordataservice.repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.Arrays;

@SpringBootApplication
public class SectorDataServiceApplication implements CommandLineRunner {
	@Autowired
	SectorsRepository sectorsRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	StockPriceRepository stockPriceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SectorDataServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//storing company
		companyRepository.save(new Company(Long.getLong("1"), 103, "SBI", 45621, "Apurv", "a,b,c,d", "Banking", "Best bank", "SBIIN"));
		companyRepository.save(new Company(Long.getLong("1"), 105, "Oriental", 45621, "Apurv", "a,b,c,d", "Banking", "Best bank", "ORIN"));
		companyRepository.save(new Company(Long.getLong("2"), 104, "SBC", 45233, "Sumit", "a,b,c,d", "Entertainment", "Best show buz", "SBCIN"));



		//sector table insert
		sectorsRepository.save(new Sectors(Long.getLong("1"), 103, "1", "Banking"));
		sectorsRepository.save(new Sectors(Long.getLong("2"), 105, "1", "Banking"));
		sectorsRepository.save(new Sectors(Long.getLong("3"), 104, "2", "Entertainment"));
		System.out.println(sectorsRepository.getAllBySectorId("1"));

		//storing stock price
		//query url:-> http://localhost:8080/company/stock/103/2020-01-04/2020-01-06
		stockPriceRepository.save(new StockPrice(Long.getLong("1"),103,456.2,"NSE",Date.valueOf("2020-01-04")));
		stockPriceRepository.save(new StockPrice(Long.getLong("2"),103,456.2,"NSE",Date.valueOf("2020-01-05")));
		stockPriceRepository.save(new StockPrice(Long.getLong("3"),103,456.2,"NSE",Date.valueOf("2020-01-06")));
		stockPriceRepository.save(new StockPrice(Long.getLong("4"),104,456.2,"NSE",Date.valueOf("2020-01-06")));
		System.out.println(stockPriceRepository.getAll(Arrays.asList(103,104), Date.valueOf("2020-01-04"),Date.valueOf("2020-01-06")));
	}
}