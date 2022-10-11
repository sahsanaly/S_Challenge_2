package com.sept.challenge2.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Account {

    @Id
    private Integer id;
    @Column
    private String accountType;
    @Column
    private String accountNumber;
    @Column
    private String accountName;
    @Column
    private String balance;
    @Column
    private LocalDate date;

    public Account() {
    }

    public Account(Integer id, String accountType, String accountNumber, String accountName, String balance, LocalDate date) {
        this.id = id;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.date = date;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
