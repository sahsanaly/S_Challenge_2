package com.sept.challenge2.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Account {

    @Id
    private Integer accountNumber;
    @Column
    private Integer id;
    @Column
    private String accountType;
    @Column
    private String accountName;
    @Column
    private String balance;
    @Column
    private LocalDate date;

    public Account() {
    }
    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer accountNumber, Integer id, String accountType, String accountName, String balance, LocalDate date) {
        this.accountNumber = accountNumber;
        this.id = id;
        this.accountType = accountType;
        this.accountName = accountName;
        this.balance = balance;
        this.date = date;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
