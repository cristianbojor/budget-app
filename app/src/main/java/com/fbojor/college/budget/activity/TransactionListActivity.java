package com.fbojor.college.budget.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.fbojor.college.budget.R;
import com.fbojor.college.budget.model.Transaction;
import com.fbojor.college.budget.model.TransactionRepository;
import com.fbojor.college.budget.util.ArrayAdapter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class TransactionListActivity extends ListActivity {
    public final static String TRANSACTION_ID = "transaction_id";
    private TransactionRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new TransactionRepository(getApplicationContext());

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
        List<Transaction> listValues = repository.getAll();

        ArrayAdapter myAdapter =
                new ArrayAdapter(this, R.layout.row_layout, R.id.transactionListItem, listValues);

        setListAdapter(myAdapter);

    }

    @Override
    protected void onDestroy() {
        repository.close();
        super.onDestroy();
    }

    public void addTransaction(View view) {
        Intent intent = new Intent(this, EditTransactionActivity.class);
        startActivity(intent);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
    }
}
