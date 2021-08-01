package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation
public class DepositTransaction extends Transaction {

    private String type = "DepositTransaction";

    public DepositTransaction(double i) {
        super.setAmount(-i);
    }


}
