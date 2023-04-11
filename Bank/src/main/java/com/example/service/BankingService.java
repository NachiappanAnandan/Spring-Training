package com.example.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.InsufficientBalance;
import com.example.exception.UserFoundException;
import com.example.exception.UserUnavailableException;
import com.example.model.BankDAO;
import com.example.model.BankDTO;


/**
 * Banking Services
 * @author Nachiappan
 *
 */

@Service("bankService")
public class BankingService implements BankingServiceInterface{
	
	
	@Autowired
	private BankDAO dao;

	/**
	 * Find the user by id
	 * 
	 * @param id
	 * @return user
	 */
	@Override
	public BankDTO findUser(int id) throws NoSuchElementException {
		Optional<BankDTO> dto = dao.findById(Integer.valueOf(id));
		if(!dto.isPresent()) {
			throw new NoSuchElementException();
		}
		BankDTO user = dto.get();
		return user;
	}

	/**
	 * adding the amount to the user
	 * 
	 * @param id
	 * @param amount
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void credit(int id, int amount) throws UserUnavailableException {
		Optional<BankDTO> dto = dao.findById(Integer.valueOf(id));
		if(amount<=0) {
			throw new UserUnavailableException("Enter a valid Amount");
		}
		if(!dto.isPresent()) {
			throw new UserUnavailableException("User id of "+ id+" Not found");
		}
		BankDTO user = dto.get();
		user.setAmount(user.getAmount()+amount);
		dao.save(user);
	}

	/**
	 * subtracting the amount from the user
	 * 
	 * @param id
	 * @param amount
	 * @throws InsufficientBalance
	 * @throws NoSuchElementException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS , rollbackFor = {InsufficientBalance.class})
	public void debit(int id, int amount) throws InsufficientBalance, UserUnavailableException {
		Optional<BankDTO> dto = dao.findById(Integer.valueOf(id));
		if(amount<=0) {
			throw new UserUnavailableException("Enter a valid Amount");
		}
		if(!dto.isPresent()) {
			throw new UserUnavailableException("User id of "+ id+" Not found");
		}
		BankDTO user = dto.get();
		if(amount> user.getAmount()) {
			throw new InsufficientBalance("There is insufficent balance in your account");
		}
		user.setAmount(user.getAmount()-amount);
		dao.save(user);
		
	}
	
	/**
	 * Create a new user
	 * 
	 * @param id
	 * @return user
	 * @throws UserFoundException
	 */
	@Override
	public void createUser(BankDTO user) throws UserFoundException{
		Optional<BankDTO> dto = dao.findById(Integer.valueOf(user.getId()));
		if(dto.isPresent()) {
			throw new UserFoundException();
		}else {
			dao.save(user);
		}
		
	}

}
