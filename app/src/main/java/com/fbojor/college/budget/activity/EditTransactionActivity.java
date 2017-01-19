package com.fbojor.college.budget.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.fbojor.college.budget.R;
import com.fbojor.college.budget.model.FirebaseTransactionRepository;
import com.fbojor.college.budget.model.Transaction;
import com.fbojor.college.budget.util.EventListener;

public class EditTransactionActivity extends AppCompatActivity implements EventListener<Transaction> {
    private EditText sum;
    private EditText details;
    private Transaction transaction;
    private FirebaseTransactionRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new FirebaseTransactionRepository(getApplicationContext());

        setContentView(R.layout.activity_edit_transaction);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        sum = (EditText) findViewById(R.id.sum);
        details = (EditText) findViewById(R.id.details);

        if (intent.hasExtra(TransactionListActivity.TRANSACTION_ID)) {
            String transactionId = intent.getStringExtra(TransactionListActivity.TRANSACTION_ID);
            repository.get(transactionId, this);
        }
    }

    public void save(View view) {
        Transaction newTransaction = new Transaction(
                transaction == null ? null : transaction.getId(),
                Double.valueOf(sum.getText().toString()),
                details.getText().toString()
        );
        repository.add(newTransaction);

        Intent intent = new Intent(this, TransactionListActivity.class);
        startActivity(intent);
    }

    public void delete(View view) {
        repository.delete(transaction);
        Intent intent = new Intent(this, TransactionListActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSuccess(Transaction data) {
        Intent intent = getIntent();
        if (intent.hasExtra(TransactionListActivity.TRANSACTION_ID)) {
            transaction = data;

            sum.setText(transaction.getSum().toString());
            details.setText(transaction.getDetails());
        }
    }


//    @Override
//    protected void onDestroy() {
//        repository.close();
//        super.onDestroy();
//    }
}
