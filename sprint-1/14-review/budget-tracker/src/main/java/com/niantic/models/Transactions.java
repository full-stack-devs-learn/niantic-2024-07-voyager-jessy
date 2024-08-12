package com.niantic.models;

import java.time.LocalDate;
import java.util.Date;


public class Transactions {
    private int transactionId;
    private int userId;
    private int subCategoryId;
    private int vendorId;
    private LocalDate transactionDate;
    private double amount;


    public Transactions(){}

    public Transactions(int transactionId, int userId, int subCategoryId, int vendorId, LocalDate transactionDate, double amount)
    {
        this.transactionId = transactionId;
        this.userId = userId;
        this.subCategoryId = subCategoryId;
        this.vendorId = vendorId;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public int getTransactionId()
    {
        return transactionId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubCategoryId()
    {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public int getVendorId()
    {
        return  vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public LocalDate getTransactionDate(){
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate)
    {
        this.transactionDate = transactionDate;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
