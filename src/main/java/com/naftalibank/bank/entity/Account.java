package com.naftalibank.bank.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
    public enum CurrencyType {
        USD, EUR, GBP
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type", nullable = false)
    private CurrencyType currency;

    private BigDecimal balance;

    private String createdAt;

    @JsonIgnore
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

    public CurrencyType getCurrencyType() {
        return currency;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currency = currencyType;
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
