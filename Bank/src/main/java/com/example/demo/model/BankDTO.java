package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bank Entity
 * 
 * @author Nachiappan
 *
 */

@Entity
@Table(name = "bank")
public class BankDTO {
	@Id
	private int id;
	private String name;
	private int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BankDTO [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	
	
	

}
