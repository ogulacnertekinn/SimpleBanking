package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="accounts")
public class Account {

    protected Account() {}

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    @Id
    @Column(name="account_number")
    private String accountNumber;

    @Column(name="owner")
    private String owner;

    @Column(name="balance")
    private double balance;

    @OneToMany(mappedBy="account")
    private List<Transaction> transactions;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void post(Transaction transaction) {
        this.setBalance(this.balance + transaction.getAmount());
    }

    public void deposit(double i) {
        this.setBalance(this.balance + i );
    }

    public void withdraw(double i) {
        this.setBalance(this.balance - i);
    }
}
