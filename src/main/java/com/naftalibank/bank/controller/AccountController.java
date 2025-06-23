package com.naftalibank.bank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naftalibank.bank.entity.Account;
import com.naftalibank.bank.repository.AccountRepository;


@RestController
@RequestMapping("api/account")
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }
    
    @PostMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return accountRepository.save(account);
    }

    @GetMapping
    public List<Account> geAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
}
