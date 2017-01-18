package com.fbojor.college.budget.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fbojor.college.budget.R;
import com.fbojor.college.budget.model.Transaction;

import java.util.List;

/**
 * Created by fbojor on 18.01.2017.
 */

public class ArrayAdapter extends android.widget.ArrayAdapter<Transaction> {
    public ArrayAdapter(Context context, int resource, int textViewResourceId, List<Transaction> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout, null);
        }

        Transaction item = getItem(position);

        TextView tv = (TextView) row.findViewById(R.id.transactionListItem);
        assert item != null;
        tv.setText(item.toString());

        // same for other fields/views; e.g. author, date etc

        return tv;
    }
}
