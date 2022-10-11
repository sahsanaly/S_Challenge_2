package com.sept.challenge2.account.controller;

import com.sept.challenge2.account.model.Account;
import com.sept.challenge2.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/")
public class AccountController {

    @Autowired
    private AccountService accountService;



    /**
     * Create new booking in the database. Booking ID is added internally.
     * @param account - booking object as json
     * @return booking object as created in database.
     * @throws Exception
     */
    @PostMapping(path = "/account", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createAccount(@RequestBody Account account)
            throws Exception {
        try{
            Account createdAccount = accountService.createAccount(account);
            if (createdAccount == null){
                return new ResponseEntity<>("Account already created!", HttpStatus.OK);
            }
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        }catch (Exception e){
            throw new Exception("Invalid id");
        }
    }

    @GetMapping(path="/account/account{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> getAccountById(@PathVariable("id") Integer id)
            throws Exception {
        Optional account = accountService.getAccountById(id);
        if (!account.isPresent()) {
            return  new ResponseEntity<>("Could not find the account for the provided id", HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(account, HttpStatus.OK);
        }
    }

    @GetMapping(path="/accounts/account", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> getAllAccounts()
            throws Exception {
        List<Account> allAccounts = accountService.getAllAccounts();
        if (allAccounts.size() > 0) {
            return  new ResponseEntity<>(allAccounts, HttpStatus.OK);
        }else  {
            return new ResponseEntity<>("No accounts found", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path="/accounts/account", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> deleteAccount(@RequestBody Account account)
            throws Exception {
        Account deletedAccount = accountService.deleteAccount(account);
        if (deletedAccount == null){
            return new ResponseEntity<>("No account exists or enter a valid id number!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Account deleted!", HttpStatus.CREATED);
    }

    @PutMapping(path = "/accounts/account", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateAccount(@RequestBody Account account)
            throws Exception {
        Account updatedAccount = accountService.updateAccount(account);
        if (updatedAccount == null){
            return new ResponseEntity<>("Nothing to update!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Account updated!", HttpStatus.CREATED);
    }


}
