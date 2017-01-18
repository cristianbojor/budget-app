package com.fbojor.college.budget.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.fbojor.college.budget.R;
import com.fbojor.college.budget.model.Transaction;
import com.fbojor.college.budget.model.TransactionRepository;

public class EditTransactionActivity extends AppCompatActivity {
    private EditText sum;
    private EditText details;
    private Transaction transaction;
    private TransactionRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new TransactionRepository(getApplicationContext());

        setContentView(R.layout.activity_edit_transaction);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        sum = (EditText) findViewById(R.id.sum);
        details = (EditText) findViewById(R.id.details);

        if (intent.hasExtra(TransactionListActivity.TRANSACTION_ID)) {
            long transactionId = intent.getLongExtra(TransactionListActivity.TRANSACTION_ID, 0);
            transaction = repository.getById(transactionId);

            sum.setText(transaction.getSum().toString());
            details.setText(transaction.getDetails());
        }
    }

    public void save(View view) {
        Transaction newTransaction = new Transaction(
                transaction == null ? null : transaction.getId(),
                Double.valueOf(sum.getText().toString()),
                details.getText().toString()
        );
        repository.save(newTransaction);

        Intent intent = new Intent(this, TransactionListActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        repository.close();
        super.onDestroy();
    }
}
