package com.naftalibank.bank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naftalibank.bank.entity.Account;
import com.naftalibank.bank.entity.AccountHolder;
import com.naftalibank.bank.repository.AccountHolderRepository;
import com.naftalibank.bank.repository.AccountRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("api/account_holder")
public class AccountHolderController {
    
    private final AccountHolderRepository accountHolderRepository;
    private final AccountRepository accountRepository;

    public AccountHolderController(AccountHolderRepository accountHolderRepository, AccountRepository accountRepository) {
        this.accountHolderRepository = accountHolderRepository;
        this.accountRepository = accountRepository;
    }

    @PostMapping
    public AccountHolder createAccountHolder(@RequestBody AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    @GetMapping
    public List<Account> getAccountHolders() {
        return accountRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public AccountHolder getAccountHolderById(Long id) {
        return accountHolderRepository.findById(id).orElse(null);                
    }




    
        
}
