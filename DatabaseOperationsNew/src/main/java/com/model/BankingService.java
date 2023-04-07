package com.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.BankExceptions.InsufficientBalanceException;

@Service("bss")
@Transactional
public class BankingService {
	
	@Autowired
	private AccountsDAO DAO;
	
	public AccountsDAO getDAO() {
		return DAO;
	}

	public void setDAO(AccountsDAO dAO) {
		DAO = dAO;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void credit(int id , int amount) {
		AccountsDTO DTO = DAO.findById(id);
		DTO.setAmount(DTO.getAmount()+amount);
		DAO.updateAccout(DTO);
	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS , rollbackFor = {InsufficientBalanceException.class})	
	public void debit(int id , int amount) throws InsufficientBalanceException {
		AccountsDTO DTO = DAO.findById(id);
		if(amount> DTO.getAmount()) {
			throw new InsufficientBalanceException("Insufficient balance...");
		}
		DTO.setAmount(DTO.getAmount()-amount);
		DAO.updateAccout(DTO);
	}

}
