package com.lesson;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transacations = new ArrayList<Double>();
    private String name;

    public Customer(String name, double initialAmt) {
        this.name = name;
        this.transacations = new ArrayList<Double>();
        addTransaction(initialAmt);


    }

    public void addTransaction(double amount){
        this.transacations.add(amount);
    }

    public ArrayList<Double> getTransacations() {
        return transacations;
    }

    public String getName() {
        return name;
    }
}
