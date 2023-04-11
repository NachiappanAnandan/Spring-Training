package com.example.exception;


/**
 * Exception for insufficient Balance
 * @author Nachiappan
 *
 */
public class InsufficientBalance extends Exception {
	private String msg;
	
	public InsufficientBalance(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String toString() {
		return  this.msg;
	}
}
