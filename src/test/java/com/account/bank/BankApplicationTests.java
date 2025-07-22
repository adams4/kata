package com.account.bank;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.account.bank.model.TransactionEntity;
import com.account.bank.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BankApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void fullIntegrationTest() {
        // Clean DB
        transactionRepository.deleteAll();

        // Deposit
        ResponseEntity<String> depositResponse = restTemplate.postForEntity("/account/deposit?amount=1000", null, String.class);
        assertThat(depositResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(depositResponse.getBody()).contains("Dépôt");

        // Withdraw
        ResponseEntity<String> withdrawResponse = restTemplate.postForEntity("/account/withdraw?amount=400", null, String.class);
        assertThat(withdrawResponse.getBody()).contains("Retrait");

        // Get balance
        ResponseEntity<String> balanceResponse = restTemplate.getForEntity("/account/balance", String.class);
        assertThat(balanceResponse.getBody()).isEqualTo("600");

        // Get statement
        ResponseEntity<TransactionEntity[]> statement = restTemplate.getForEntity("/account/statement", TransactionEntity[].class);
        assertThat(statement.getBody()).hasSize(2);
    }
}
