package com.naftalibank.bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naftalibank.bank.entity.Account;
import com.naftalibank.bank.repository.AccountRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/account")
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("path")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    
    
        
}
