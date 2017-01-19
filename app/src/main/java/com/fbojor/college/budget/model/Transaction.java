package com.fbojor.college.budget.model;

/**
 * Created by fbojor on 23.11.2016.
 */

public class Transaction {
    private String id;
    private Double sum;
    private String details;

    public Transaction() {
    }

    public Transaction(String id, Double sum, String details) {
        this.id = id;
        this.sum = sum;
        this.details = details;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "sum: " + sum + ", details: " + details;
    }
}
