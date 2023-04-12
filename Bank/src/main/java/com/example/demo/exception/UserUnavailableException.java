package com.example.demo.exception;

public class UserUnavailableException  extends Exception{
	private String msg;
	public UserUnavailableException(String msg){
		this.msg = msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
}