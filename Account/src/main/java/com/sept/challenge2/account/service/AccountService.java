package com.sept.challenge2.account.service;

import com.sept.challenge2.account.dao.AccountDao;
import com.sept.challenge2.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    public Account createAccount(Account account) {
        int numOfAccounts = accountDao.findAll().size();
        account.setId(numOfAccounts+1);
        return accountDao.save(account);
    }
}
