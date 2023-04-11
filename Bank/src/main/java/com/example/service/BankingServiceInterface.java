package com.example.service;

import org.springframework.stereotype.Repository;

import com.example.exception.InsufficientBalance;
import com.example.exception.UserFoundException;
import com.example.exception.UserUnavailableException;
import com.example.model.BankDTO;

@Repository
public interface BankingServiceInterface {

	public BankDTO findUser(int id);
	public void createUser(BankDTO user) throws UserFoundException;
	public void credit(int id , int amount) throws UserUnavailableException;
	public void debit(int id, int amount) throws InsufficientBalance ,UserUnavailableException;
	
}
