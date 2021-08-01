package com.eteration.simplebanking.model;


import javax.persistence.*;
import java.util.Date;

// This class is a place holder you can change the complete implementation
@Entity
@Table(name="transactions")
public abstract class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long transactionId;

    @Column(name="date")
    private Date date;

    @Column(name="amount")
	private double amount;

    @Column(name="type")
    private String type;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
	private Account account;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
