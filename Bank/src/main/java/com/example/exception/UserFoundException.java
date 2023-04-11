package com.example.exception;


/**
 * Exception class for User Already Found
 * @author Nachiappan
 *
 */
public class UserFoundException extends Exception{
	
	private String msg = "User Already Found";
	 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}

}
