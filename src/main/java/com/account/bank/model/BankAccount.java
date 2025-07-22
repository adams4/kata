package com.account.bank.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private int balance = 0;
    private final List<Transaction> transactions = new ArrayList<>();

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Le montant du dépôt doit être positif.");
        balance += amount;
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }

    public void withdraw(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Le montant du retrait doit être positif.");
        if (amount > balance) throw new IllegalStateException("Fonds insuffisants.");
        balance -= amount;
        transactions.add(new Transaction(LocalDate.now(), -amount, balance));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getBalance() {
        return balance;
    }
}
