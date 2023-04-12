package com.example.demo.controller;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.BankDTO;
import com.example.demo.model.TranssactionData;
import com.example.demo.service.BankingService;
import com.example.demo.service.TransactionService;

/**
 * Bank Controller contains the functions to be executed for a bank transaction
 * 
 * @author Nachiappan
 * 
 */
@RestController
@ComponentScan(basePackages = {"com.example.service"})
@RequestMapping(value = "bank")
public class BankController {
	
	@Autowired
	private BankingService bs;
	
	@Autowired
	private TransactionService ts;
	
	/**
	 * Home page of interface
	 * 
	 * @param mv
	 * @return model and view
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView checkRoute(ModelAndView mv) {
		mv.setViewName("BankForm");
		return mv;
	}
	
	/**
	 * Interface for create user
	 * 
	 * @param mv
	 * @return model and view
	 */
	@RequestMapping(method = RequestMethod.GET , value ="createUser")
	public ModelAndView createUser(ModelAndView mv) {
		BankDTO user = new BankDTO();
		mv.addObject("user", user);
		mv.setViewName("CreateUser");
		return mv;
	}
	
	/**
	 * Value passed to create user
	 * 
	 * @param user
	 * @param mv
	 * @return model and view
	 */
	@RequestMapping(method = RequestMethod.POST , value ="createUser")
	public ModelAndView createUser(BankDTO user , ModelAndView mv){
		
		try {
			bs.createUser(user);
			mv.addObject("msg" ,"User Successfully Created");
			mv.setViewName("Message");
		} catch (Exception e) {
			mv.addObject("msg" ,e);
			mv.setViewName("Message");
		}
		
		return mv;
		
	}
	
	/**
	 * 
	 * Interface for checking balance
	 * @param mv
	 * @return model and view
	 */
	@RequestMapping(method = RequestMethod.GET , value ="checkBalance")
	public ModelAndView CheckUser(ModelAndView mv) {
		BankDTO user = new BankDTO();
		mv.addObject("user", user);
		mv.setViewName("checkUser");
		return mv;
	}
	
	
	/**
	 * 
	 * Execution of Checking Balance
	 * 
	 * @param user
	 * @param mv
	 * @return model and view
	 */
	@RequestMapping(method = RequestMethod.POST , value ="checkBalance")
	public ModelAndView CheckUser(BankDTO user , ModelAndView mv) {
		
		try {
			BankDTO userData = bs.findUser(user.getId());
			mv.addObject("id", userData.getId() );
			mv.addObject("name", userData.getName());
			mv.addObject("amount", userData.getAmount());
			mv.setViewName("User");
		}
		catch(NoSuchElementException e) {
			mv.addObject("msg" , "User Not Found");
			mv.setViewName("Message");
		}
		return mv;
		
	}
	
	/**
	 * Interface for Do Transfer
	 * @param mv
	 * @return model and view
	 */
	@RequestMapping(method = RequestMethod.GET , value ="doTransfer")
	public ModelAndView doTransaction(ModelAndView mv) {
		TranssactionData transactionData = new TranssactionData();
		mv.addObject("transaction", transactionData);
		mv.setViewName("Transaction");
		return mv;
	}
	
	/**
	 * Execution for do Transaction
	 * 
	 * @param mv
	 * @param transactionData
	 * @return model and view
	 */
	@RequestMapping(method = RequestMethod.POST , value ="doTransfer")
	public ModelAndView doTransaction(ModelAndView mv ,TranssactionData transactionData) {
		
		try {
			ts.doTransaction(transactionData.getId1(), transactionData.getId2(), transactionData.getAmount());
			mv.addObject("msg" , "Transaction success");
			mv.setViewName("Message");
		}
		catch (Exception e) {
			mv.addObject("msg" , e);
			mv.setViewName("Message");
			return mv;
		}
		
		return mv;
	}
}

