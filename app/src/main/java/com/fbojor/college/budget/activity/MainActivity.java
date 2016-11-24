package com.fbojor.college.budget.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.fbojor.college.budget.R;

import de.cketti.mailto.EmailIntentBuilder;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);

        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();

        String body = String.format("Email %s\nPassword %s", emailText, passwordText);

        EmailIntentBuilder.from(this)
                .to(emailText)
                .subject("test email")
                .body(body)
                .start();

    }

    public void viewTransactionList(View view) {
        Intent intent = new Intent(this, TransactionListActivity.class);
        startActivity(intent);
    }
}
