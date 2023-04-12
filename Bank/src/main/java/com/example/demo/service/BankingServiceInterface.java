package com.example.demo.service;

import org.springframework.stereotype.Repository;

import com.example.demo.exception.InsufficientBalanceException;
import com.example.demo.exception.UserFoundException;
import com.example.demo.exception.UserUnavailableException;
import com.example.demo.model.BankDTO;

@Repository
public interface BankingServiceInterface {

	public BankDTO findUser(int id);
	public void createUser(BankDTO user) throws UserFoundException;
	public void credit(int id , int amount) throws UserUnavailableException;
	public void debit(int id, int amount) throws InsufficientBalanceException ,UserUnavailableException;
	
}
