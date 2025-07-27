package com.naftalibank.bank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naftalibank.bank.entity.AccountHolder;
import com.naftalibank.bank.repository.AccountHolderRepository;
import com.naftalibank.bank.repository.AccountRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/account_holder")
public class AccountHolderController {

    private final AccountHolderRepository accountHolderRepository;

    public AccountHolderController(AccountHolderRepository accountHolderRepository,
            AccountRepository accountRepository) {
        this.accountHolderRepository = accountHolderRepository;
    }

    @PostMapping("/register")
    public AccountHolder createAccountHolder(@RequestBody AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    @PutMapping("/{id}")
    public AccountHolder updateAccountHolder(@PathVariable Long id, @RequestBody AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    @GetMapping
    public List<AccountHolder> getAccountHolders() {
        return accountHolderRepository.findAll();
    }

    @GetMapping("/{id}")
    public AccountHolder getAccountHolderById(Long id) {
        return accountHolderRepository.findById(id).orElse(null);
    }

}
