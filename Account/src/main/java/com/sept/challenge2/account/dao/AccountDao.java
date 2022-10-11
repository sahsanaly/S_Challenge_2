package com.sept.challenge2.account.dao;

import com.sept.challenge2.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {
}
