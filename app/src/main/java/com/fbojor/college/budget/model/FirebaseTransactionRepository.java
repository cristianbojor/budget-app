package com.fbojor.college.budget.model;

import android.content.Context;

import com.fbojor.college.budget.util.ListEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by STEFAN on 1/17/2017.
 */

public class FirebaseTransactionRepository {
    private DatabaseReference reference;

    public FirebaseTransactionRepository(Context ctx) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference("transactions");
        reference.keepSynced(true);
    }

    public void getAll(final ListEventListener<Transaction> listener) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                List<Transaction> transactions = new ArrayList<>();
                //shake hands with each of them
                for (DataSnapshot child : children) {
                    Transaction transaction = child.getValue(Transaction.class);
                    transactions.add(transaction);
                }
                listener.onSuccess(transactions);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void delete(Transaction transaction) {
        reference.child(transaction.getId()).removeValue();
    }

    public Transaction add(Transaction transaction) {
        String key = reference.push().getKey();
        Transaction persisted = new Transaction(
                key,
                transaction.getSum(),
                transaction.getDetails()
        );
        reference.child(key).setValue(persisted);
        return persisted;
    }

    public void update(Transaction transaction) {
        reference.child(transaction.getId()).setValue(transaction);
    }
}
