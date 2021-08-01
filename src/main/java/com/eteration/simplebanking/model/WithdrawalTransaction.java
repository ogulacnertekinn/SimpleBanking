package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation
public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(double i) {
        super.setAmount(i);
    }

    private String type = "WithdrawalTransaction";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


