package com.account.bank.service;

import com.account.bank.model.TransactionEntity;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountServiceTest {

    @Test
    void deposit_shouldIncreaseBalance() {
        BankAccountUnitService service = new BankAccountUnitService();
        service.deposit(500);
        assertEquals(500, service.getBalance());
    }

    @Test
    void withdraw_shouldDecreaseBalance() {
        BankAccountUnitService service = new BankAccountUnitService();
        service.deposit(1000);
        service.withdraw(400);
        assertEquals(600, service.getBalance());
    }

    @Test
    void withdraw_shouldThrowException_whenInsufficientFunds() {
        BankAccountUnitService service = new BankAccountUnitService();
        service.deposit(100);
        assertThrows(IllegalStateException.class, () -> service.withdraw(200));
    }

    @Test
    void getTransactions_shouldReturnCorrectHistory() {
        BankAccountService service = new BankAccountService(null);
        service.deposit(200);
        service.withdraw(50);
        List<TransactionEntity> history = service.getTransactions();
        assertEquals(2, history.size());
        assertEquals(200, history.get(0).getAmount());
        assertEquals(-50, history.get(1).getAmount());
    }
}
