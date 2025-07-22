package com.account.bank.service;
import com.account.bank.model.BankAccount;
import com.account.bank.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountUnitService {

    private final BankAccount bankAccount = new BankAccount();

    public void deposit(int amount) {
        bankAccount.deposit(amount);
    }

    public void withdraw(int amount) {
        bankAccount.withdraw(amount);
    }

    public int getBalance() {
        return bankAccount.getBalance();
    }

    public List<Transaction> getTransactions() {
        return bankAccount.getTransactions();
    }
}