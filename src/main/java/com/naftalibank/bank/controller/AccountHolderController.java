package com.naftalibank.bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naftalibank.bank.repository.AccountHolderRepository;

@RestController
@RequestMapping("api/account_holder")
public class AccountHolderController {
    
    private final AccountHolderRepository accountHolderRepository;
}
