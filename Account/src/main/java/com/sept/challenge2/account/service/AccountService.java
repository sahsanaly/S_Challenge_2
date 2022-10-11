package com.sept.challenge2.account.service;

import com.sept.challenge2.account.dao.AccountDao;
import com.sept.challenge2.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;
}
