package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

// This class is a place holder you can change the complete implementation
@RestController
@RequestMapping(value = "/account/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;
    private Object TransactionStatus;

    @GetMapping(value = "/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        return new ResponseEntity(accountService.findAccount(accountNumber), HttpStatus.OK);
    }

    @PostMapping(value = "/credit/{accountNumber}")
    @Transactional
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, @RequestBody Transaction transaction) {
        Account processingAccount = this.accountService.findAccount(accountNumber);
        processingAccount.getTransactions().add(transaction);
        processingAccount.deposit(transaction.getAmount());
        accountService.save(processingAccount);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/debit/{accountNumber}")
    @Transactional
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, @RequestBody Transaction transaction) {
        Account processingAccount = this.accountService.findAccount(accountNumber);
        processingAccount.getTransactions().add(transaction);
        processingAccount.withdraw(transaction.getAmount());
        accountService.save(processingAccount);
        return new ResponseEntity(HttpStatus.OK);
    }
}