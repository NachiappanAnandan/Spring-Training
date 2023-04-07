package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("AccountDAO")
public class AccountsDAO {
	
	@Autowired
	private SessionFactory factory;
	
//	find by id
	public AccountsDTO findById(int id) {
		Session session = factory.getCurrentSession();
		System.out.println(id);
		AccountsDTO dto = session.get(AccountsDTO.class , Integer.valueOf(id));
		return dto;
	}

//	update DTO
	public void updateAccout(AccountsDTO dto) {
		Session session = factory.getCurrentSession();
		session.persist(dto);
	}
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
}
