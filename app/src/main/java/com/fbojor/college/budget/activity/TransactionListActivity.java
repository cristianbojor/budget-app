package com.fbojor.college.budget.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fbojor.college.budget.R;
import com.fbojor.college.budget.model.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionListActivity extends ListActivity {
    public final static String TRANSACTION_POSITION = "transaction_position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list);

        initAdapter();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(this, EditTransactionActivity.class);
        intent.putExtra(TRANSACTION_POSITION, position);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        initAdapter();
    }

    private void initAdapter() {
        List<String> listValues = Transaction.getAll().stream()
                .map(Transaction::toString)
                .collect(Collectors.toList());

        ArrayAdapter<String> myAdapter =
                new ArrayAdapter<>(this, R.layout.row_layout, R.id.transactionListItem, listValues);

        setListAdapter(myAdapter);

    }
}
