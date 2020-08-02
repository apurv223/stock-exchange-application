package com.example.stock.exchange.stockexchangedataservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
