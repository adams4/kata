package com.account.bank.service;
import com.account.bank.model.TransactionEntity;
import com.account.bank.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BankAccountService {

    private int balance = 0;
    private final TransactionRepository transactionRepository;

    public BankAccountService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Le montant du dépôt doit être positif.");
        balance += amount;
        saveTransaction(amount);
    }

    public void withdraw(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Le montant du retrait doit être positif.");
        if (amount > balance) throw new IllegalStateException("Fonds insuffisants.");
        balance -= amount;
        saveTransaction(-amount);
    }

    private void saveTransaction(int amount) {
        TransactionEntity t = new TransactionEntity(LocalDate.now(), amount, balance);
        transactionRepository.save(t);
    }

    public int getBalance() {
        return balance;
    }

    public List<TransactionEntity> getTransactions() {
        return transactionRepository.findAll();
    }
}
