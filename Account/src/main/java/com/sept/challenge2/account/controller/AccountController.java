package com.sept.challenge2.account.controller;

import com.sept.challenge2.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
}
