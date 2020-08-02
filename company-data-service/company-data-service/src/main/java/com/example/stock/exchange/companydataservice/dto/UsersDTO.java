package com.example.stock.exchange.companydataservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {

	private String username;
	private String password;
	private String userType;//(if Admin or normal User)
	private String email;
	private long mobileNumber;
	private int confirmed;


}
