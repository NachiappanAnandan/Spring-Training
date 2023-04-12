package com.example.demo.exception;


/**
 * Exception for insufficient Balance
 * @author Nachiappan
 *
 */
public class InsufficientBalanceException extends Exception {
	private String msg;
	
	public InsufficientBalanceException(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String toString() {
		return  this.msg;
	}
}
