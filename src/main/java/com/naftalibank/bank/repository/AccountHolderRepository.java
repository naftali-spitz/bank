package com.naftalibank.bank.repository;

import com.naftalibank.bank.entity.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
    
}
