package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.BankExceptions.InsufficientBalanceException;
import com.model.AccountsDAO;
import com.model.AccountsDTO;
import com.model.MyService;
import com.model.Transaction;

@SpringBootApplication
public class DatabaseOperationsNewApplication {

	public static void main(String[] args) throws InsufficientBalanceException {
		ApplicationContext ctx =  SpringApplication.run(DatabaseOperationsNewApplication.class, args);
		
//		MyService service = ctx.getBean("myService" , MyService.class);
//		service.doServe(1,1000);
		
		Transaction ts = ctx.getBean("tss" , Transaction.class);
		
		ts.doTransaction(2, 1, 100);
		
		
		
	}

}
