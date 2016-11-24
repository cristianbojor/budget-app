package com.fbojor.college.budget.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by fbojor on 23.11.2016.
 */

public class Transaction {
    private static List<Transaction> all;

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

    public static List<Transaction> getAll() {
        if (all == null) {
            initAll();
        }
        return all;

    }

    private static void initAll() {
        all = Arrays.asList(
                new Transaction(1L, 25d, "Shopping"),
                new Transaction(2L, 10.2d, "Fuel"),
                new Transaction(3L, 646.2d, "Home"),
                new Transaction(4L, 252d, "Products"),
                new Transaction(5L, 6367d, "Food"),
                new Transaction(6L, 636d, "Clothes")
        );
    }

    @Override
    public String toString() {
        return "sum: " + sum + ", details: " + details;
    }

    public static void update(Transaction newTransaction) {
        all = getAll().stream()
                .filter(t -> !t.getId().equals(newTransaction.getId()))
                .collect(Collectors.toList());

        all.add(newTransaction);
        all.sort(Comparator.comparing(Transaction::getId));
    }
}
