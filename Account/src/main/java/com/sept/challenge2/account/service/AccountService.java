package com.sept.challenge2.account.service;

import com.sept.challenge2.account.dao.AccountDao;
import com.sept.challenge2.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    public Account createAccount(Account account) {
        List<Account> numOfAccounts = accountDao.findAll();
        for (int i=0; i<numOfAccounts.size();i++){
            if (i>0) {
                if (i == numOfAccounts.size() - 1) {
                    account.setAccountNumber(numOfAccounts.get(i).getAccountNumber() + 1);
                    return accountDao.save(account);
                }
            }else{
                account.setAccountNumber(numOfAccounts.get(i).getAccountNumber() + 1);
                return accountDao.save(account);
            }
        }
        return null;
    }

    public Optional getAccountById(Integer id) throws NoSuchElementException{
        try {
            return accountDao.findById(id);
        } catch (Exception e) {
            throw new NoSuchElementException("Account ID not found");
        }
    }

    public List<Account> getAllAccounts(){
            List<Account> allAccounts = accountDao.findAll();
            return allAccounts;
    }

    public Account updateAccount(Account account) {
        List<Account> allAccounts = accountDao.findAll();
        for (int i=0; i<allAccounts.size();i++){
            if (allAccounts.get(i).getAccountNumber()==account.getAccountNumber()){
                allAccounts.get(i).setId(account.getId());
                allAccounts.get(i).setAccountName(account.getAccountName());
                allAccounts.get(i).setAccountType(account.getAccountType());
                allAccounts.get(i).setBalance(account.getBalance());
                allAccounts.get(i).setDate(account.getDate());

                accountDao.save(allAccounts.get(i));
                return allAccounts.get(i);
            }
        }
        return null;
    }

    public Account deleteAccount(Account account){
        List<Account> allAccounts = accountDao.findAll();
        for (int i=0; i<allAccounts.size();i++){
            if (allAccounts.get(i).getAccountNumber()==account.getAccountNumber() &&
                    allAccounts.get(i).getId()==account.getId()) {
                accountDao.delete(allAccounts.get(i));
                return allAccounts.get(i);
            }
        }
        return null;
    }

}
