package com.example.bank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankApplicationTests {

    @Test
    void deposit_shouldIncreaseBalance() {
        BankAccount account = new BankAccount();
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void withdraw_shouldDecreaseBalance() {
        BankAccount account = new BankAccount();
        account.deposit(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    void withdraw_shouldThrowException_whenInsufficientFunds() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        Exception e = assertThrows(IllegalStateException.class, () -> account.withdraw(200));
        assertEquals("Fonds insuffisants.", e.getMessage());
    }

    @Test
    void printStatement_shouldNotThrow() {
        BankAccount account = new BankAccount();
        account.deposit(1000);
        account.withdraw(200);
        account.printStatement(); 
    }
}

