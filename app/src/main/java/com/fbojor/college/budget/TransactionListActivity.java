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

public class TransactionListActivity extends ListActivity {
    private final List<Transaction> transactions = Transaction.getRandomList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list);

        List<String> listValues = getStringValues(transactions);

        ArrayAdapter<String> myAdapter =
                new ArrayAdapter<>(this, R.layout.row_layout, R.id.transactionListItem, listValues);

        setListAdapter(myAdapter);

    }

    private List<String> getStringValues(List<Transaction> transactions) {
        List<String> result = new ArrayList<>();

        for (Transaction transaction : transactions) {
            result.add(transaction.toString());
        }

        return result;
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Transaction transaction = transactions.get(position);


        System.out.println(transaction);

    }

}
