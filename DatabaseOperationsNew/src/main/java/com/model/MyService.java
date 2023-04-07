package com.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyService {
	@Autowired
	private AccountsDAO DAO;
	public AccountsDAO getDAO() {
		return DAO;
	}
	public void setDAO(AccountsDAO dAO) {
		DAO = dAO;
	}
	public void doServe(int id , int amount) {
		AccountsDTO DTO = DAO.findById(id);
		DTO.setAmount(amount);
		DAO.updateAccout(DTO);
	}
}
