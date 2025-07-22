package com.account.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.bank.model.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
