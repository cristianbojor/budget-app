package com.fbojor.college.budget.model;

/**
 * Created by fbojor on 23.11.2016.
 */

public class Transaction {
    private final Long id;
    private final Double sum;
    private final String details;

    public Transaction(Long id, Double sum, String details) {
        this.id = id;
        this.sum = sum;
        this.details = details;
    }

    public Double getSum() {
        return sum;
    }

    public String getDetails() {
        return details;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "sum: " + sum + ", details: " + details;
    }
}
