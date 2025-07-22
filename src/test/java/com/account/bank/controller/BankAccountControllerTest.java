package com.account.bank.controller;

import com.account.bank.service.BankAccountService;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BankAccountController.class)
class BankAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BankAccountService bankAccountService;

    @Test
    void deposit_shouldReturnSuccessMessage() throws Exception {
        mockMvc.perform(post("/account/deposit?amount=500"))
                .andExpect(status().isOk())
                .andExpect(content().string("Dépôt de 500 effectué."));
    }

    @Test
    void withdraw_shouldReturnSuccessMessage() throws Exception {
        mockMvc.perform(post("/account/withdraw?amount=200"))
                .andExpect(status().isOk())
                .andExpect(content().string("Retrait de 200 effectué."));
    }

    @Test
    void withdraw_shouldReturnErrorMessage_whenInsufficientFunds() throws Exception {
        doThrow(new IllegalStateException("Fonds insuffisants."))
                .when(bankAccountService).withdraw(1000);

        mockMvc.perform(post("/account/withdraw?amount=1000"))
                .andExpect(status().isOk())
                .andExpect(content().string("Erreur : Fonds insuffisants."));
    }

    @Test
    void getBalance_shouldReturnIntValue() throws Exception {
        when(bankAccountService.getBalance()).thenReturn(750);

        mockMvc.perform(get("/account/balance"))
                .andExpect(status().isOk())
                .andExpect(content().string("750"));
    }

    @Test
    void getStatement_shouldReturnJsonArray() throws Exception {
        when(bankAccountService.getTransactions()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/account/statement"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}
