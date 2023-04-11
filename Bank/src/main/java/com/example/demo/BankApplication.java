package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.exception.InsufficientBalance;



@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = {"com.example.model"})
@EntityScan("com.example.model")
public class BankApplication {

	public static void main(String[] args) throws InsufficientBalance {
		 ConfigurableApplicationContext ctx =  SpringApplication.run(BankApplication.class, args);
		 
//		 BankingService bs = ctx.getBean("bankService" , BankingService.class);
//		 TransactionService ts = ctx.getBean("transaction" , TransactionService.class);
////		 BankDTO user = new BankDTO();
//		 
//		 ts.doTransaction(1, 2, 1000);
//		 user.setAmount(500);
//		 user.setName("Balu");
//		 bs.createUser(user);
//		 
//		user =  bs.findUser(1);
//		System.out.println(user);
		 
		 
		 
		 
	}

}
