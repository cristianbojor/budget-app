package com.fbojor.college.budget.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.fbojor.college.budget.R;
import com.fbojor.college.budget.model.FirebaseTransactionRepository;
import com.fbojor.college.budget.model.Transaction;
import com.fbojor.college.budget.util.ArrayAdapter;
import com.fbojor.college.budget.util.ListEventListener;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class TransactionListActivity extends ListActivity implements ListEventListener<Transaction> {
    public final static String TRANSACTION_ID = "transaction_id";
    private FirebaseTransactionRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new FirebaseTransactionRepository(getApplicationContext());

        setContentView(R.layout.activity_transaction_list);

        initAdapter();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Transaction transaction = (Transaction) l.getItemAtPosition(position);

        Intent intent = new Intent(this, EditTransactionActivity.class);
        intent.putExtra(TRANSACTION_ID, transaction.getId());
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        initAdapter();
    }

    private void initAdapter() {
        repository.getAll(this);
    }


    public void addTransaction(View view) {
        Intent intent = new Intent(this, EditTransactionActivity.class);
        startActivity(intent);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
    }

    @Override
    public void onSuccess(List<Transaction> elements) {
        ArrayAdapter myAdapter =
                new ArrayAdapter(this, R.layout.row_layout, R.id.transactionListItem, elements);

        setListAdapter(myAdapter);

    }
}
