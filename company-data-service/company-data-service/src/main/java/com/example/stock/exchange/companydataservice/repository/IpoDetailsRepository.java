package com.example.stock.exchange.companydataservice.repository;

import com.example.stock.exchange.companydataservice.model.IpoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpoDetailsRepository extends JpaRepository<IpoDetails,Long> {
    public IpoDetails findByCompanyName(String companyName);
}
