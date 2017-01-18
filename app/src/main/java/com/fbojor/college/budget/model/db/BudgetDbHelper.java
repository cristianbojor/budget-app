package com.fbojor.college.budget.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fbojor on 18.01.2017.
 */

public class BudgetDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Budget.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + BudgetContract.BudgetEntry.TABLE_NAME + " (" +
                    BudgetContract.BudgetEntry._ID + " INTEGER PRIMARY KEY," +
                    BudgetContract.BudgetEntry.COLUMN_NAME_DETAILS + " TEXT," +
                    BudgetContract.BudgetEntry.COLUMN_NAME_SUM + " INTEGER)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + BudgetContract.BudgetEntry.TABLE_NAME;

    public BudgetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
