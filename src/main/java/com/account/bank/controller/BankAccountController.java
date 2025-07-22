package com.account.bank.controller;

import com.account.bank.model.TransactionEntity;
import com.account.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/deposit")
    public String deposit(@RequestParam int amount) {
        bankAccountService.deposit(amount);
        return "Dépôt de " + amount + " effectué.";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam int amount) {
        try {
            bankAccountService.withdraw(amount);
            return "Retrait de " + amount + " effectué.";
        } catch (IllegalStateException e) {
            return "Erreur : " + e.getMessage();
        }
    }

    @GetMapping("/balance")
    public int getBalance() {
        return bankAccountService.getBalance();
    }

    // @GetMapping("/statement")
    // public List<Transaction> getStatement() {
    //     return bankAccountService.getTransactions();
    // }
    @GetMapping("/statement")
    public List<TransactionEntity> getStatement() {
        return bankAccountService.getTransactions();
    }

}
