package com.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.BankExceptions.InsufficientBalanceException;

@Service("tss")

public class Transaction {
	
	@Autowired
	private BankingService bss;

	public BankingService getBss() {
		return bss;
	}

	public void setBss(BankingService bss) {
		this.bss = bss;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void doTransaction(int id1, int id2, int amt) throws InsufficientBalanceException {
		bss.credit(id1, amt);
		bss.debit(id2, amt);
		
	}
}
