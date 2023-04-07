package com.BankExceptions;

public class InsufficientBalanceException extends Exception{

	private String msg;
	
	public InsufficientBalanceException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		
		return "Exception is ...."+" "+this.msg;
	}
	
}
