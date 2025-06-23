package com.naftalibank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naftalibank.bank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
