package com.fbojor.college.budget;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fbojor.college.budget.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionListActivity extends ListActivity {
    private final List<Transaction> transactions = Transaction.getRandomList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list);

        List<String> listValues = transactions.stream()
                .map(Transaction::toString)
                .collect(Collectors.toList());

        ArrayAdapter<String> myAdapter =
                new ArrayAdapter<>(this, R.layout.row_layout, R.id.transactionListItem, listValues);

        setListAdapter(myAdapter);

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Transaction transaction = transactions.get(position);


        System.out.println(transaction);

    }

}
