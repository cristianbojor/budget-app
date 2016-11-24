package com.fbojor.college.budget.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.fbojor.college.budget.R;
import com.fbojor.college.budget.model.Transaction;

public class EditTransactionActivity extends AppCompatActivity {
    private EditText sum;
    private EditText details;
    private Transaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_transaction);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        sum = (EditText) findViewById(R.id.sum);
        details = (EditText) findViewById(R.id.details);

        transaction =
                getTransaction(intent.getIntExtra(TransactionListActivity.TRANSACTION_POSITION, 0));

        sum.setText(transaction.getSum().toString());
        details.setText(transaction.getDetails());
    }

    private Transaction getTransaction(int position) {
        return Transaction.getAll().get(position);
    }

    public void save(View view) {
        Transaction newTransaction = new Transaction(
                transaction.getId(),
                Double.valueOf(sum.getText().toString()),
                details.getText().toString()
        );
        Transaction.update(newTransaction);

        Intent intent = new Intent(this, TransactionListActivity.class);
        startActivity(intent);
    }

}
