package com.fbojor.college.budget.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fbojor on 23.11.2016.
 */

public class Transaction {
    private final Long id;
    private final Date date;
    private final Double sum;
    private final String details;

    public Transaction(Long id, Date date, Double sum, String details) {
        this.id = id;
        this.date = date;
        this.sum = sum;
        this.details = details;
    }

    public Date getDate() {
        return date;
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

    public static List<Transaction> getRandomList() {
        List<Transaction> result = new ArrayList<>();

        result.add(new Transaction(1L, new Date(), 25d, "Shopping"));
        result.add(new Transaction(2L, new Date(), 10.2d, "Fuel"));
        result.add(new Transaction(3L, new Date(), 646.2d, "Home"));
        result.add(new Transaction(4L, new Date(), 252d, "Products"));
        result.add(new Transaction(5L, new Date(), 6367d, "Food"));
        result.add(new Transaction(6L, new Date(), 636d, "Clothes"));

        return result;
    }

    @Override
    public String toString() {
        return "date: " + date +
                ", sum: " + sum +
                ", details: " + details;
    }
}
