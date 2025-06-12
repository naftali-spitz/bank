package com.naftalibank.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.naftalibank.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);
}
