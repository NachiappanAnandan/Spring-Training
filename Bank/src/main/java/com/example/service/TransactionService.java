package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.InsufficientBalance;
import com.example.exception.UserUnavailableException;

/**
 * Service For Execution of Transaction
 * @author Nachiappan
 *
 */

@Service("transaction")
@Transactional
public class TransactionService {
	
	@Autowired
	private BankingService bs;
	/**
	 * Method that Executes the credit and debit
	 * 
	 * @param id1
	 * @param id2
	 * @param amount
	 * @throws InsufficientBalance
	 * @throws UserUnavailableException 
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {InsufficientBalance.class})
	public void doTransaction(int id1,int id2,int amount) throws InsufficientBalance, UserUnavailableException {
			bs.credit(id1, amount);
			bs.debit(id2, amount);
	}
	
}
