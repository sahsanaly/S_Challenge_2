package com.sept.challenge2.account.service;

import com.sept.challenge2.account.dao.AccountDao;
import com.sept.challenge2.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    public Account createAccount(Account account) {
        int numOfAccounts = accountDao.findAll().size();
        account.setAccountNumber(numOfAccounts+1);
        return accountDao.save(account);
    }

    public Optional getAccountById(Integer id) throws NoSuchElementException{
        try {
            return accountDao.findById(id);
        } catch (Exception e) {
            throw new NoSuchElementException("Booking ID not found");
        }
    }

}
