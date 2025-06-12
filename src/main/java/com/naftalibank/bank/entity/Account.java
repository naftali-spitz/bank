package com.naftalibank.bank.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

public class Account {
    public enum CurrencyType {
        USD, EUR, GBP
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private Long id;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type", nullable = false)
    private String currencyType;

    private BigDecimal balance;
    
    private String createdAt;

    @ManyToMany(mappedBy = "accounts")
    private Set<AccountHolder> accountHolders = new HashSet<>();

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Set<AccountHolder> getAccountHolders() {
        return accountHolders;
    }

    public void setAccountHolders(Set<AccountHolder> accountHolders) {
        this.accountHolders = accountHolders;
    }

    public void addAccountHolder(AccountHolder accountHolder) {
        this.accountHolders.add(accountHolder);
        accountHolder.getAccounts().add(this);
    }

    public void removeAccountHolder(AccountHolder accountHolder) {
        this.accountHolders.remove(accountHolder);
        accountHolder.getAccounts().remove(this);
    }

    

}
