package com.lesson;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if (branchName != null){
            return branch.newCustomer(customerName,initialAmount);
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addTransaction(customerName,amount);
        }
        return false;
    }

    private Branch findBranch(String customerName){
        for (int i = 0; i <this.branches.size();i++){
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(customerName)){
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if (branch != null){
            System.out.println("customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer " + branchCustomer.getName() + "[" + i + "]");
                if (showTransactions){
                    System.out.println("transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransacations();
                    for (int j = 0; j < transactions.size();j++){
                        System.out.println("[" + (j+1) + "]  Amount " + transactions.get(j));
                    }
                }
            }
        }

        return false;
    }














}
