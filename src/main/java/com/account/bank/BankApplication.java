package com.example.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		 BankAccount account = new BankAccount();
        account.deposit(1000);
        account.withdraw(250);
        account.printStatement();
    
		SpringApplication.run(BankApplication.class, args);
	}

}
