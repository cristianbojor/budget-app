package com.fbojor.college.budget.model;

/**
 * Created by fbojor on 18.01.2017.
 */

public class TransactionRepository {
//    private static final String[] TRANSACTION_PROJECTION = {
//            BudgetEntry._ID,
//            BudgetEntry.COLUMN_NAME_DETAILS,
//            BudgetEntry.COLUMN_NAME_SUM
//    };
//    private BudgetDbHelper dbHelper;
//
//
//    public TransactionRepository(Context context) {
//        this.dbHelper = new BudgetDbHelper(context);
//    }
//
////    public Transaction save(Transaction transaction) {
////        if (transaction.getId() != null) {
//////            delete(transaction.getId());
////        }
////
////        // Gets the data repository in write mode
////        SQLiteDatabase db = dbHelper.getWritableDatabase();
////
////        // Create a new map of values, where column names are the keys
////        ContentValues values = new ContentValues();
////        values.put(BudgetEntry.COLUMN_NAME_DETAILS, transaction.getDetails());
////        values.put(BudgetEntry.COLUMN_NAME_SUM, transaction.getSum());
////
////        // Insert the new row, returning the primary key value of the new row
////        long newRowId = db.insert(BudgetEntry.TABLE_NAME, null, values);
////
////        return new Transaction(
////                newRowId,
////                transaction.getSum(),
////                transaction.getDetails()
////        );
////    }
//
//    public List<Transaction> getAll() {
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        Cursor cursor = db.query(
//                BudgetEntry.TABLE_NAME,                     // The table to query
//                TRANSACTION_PROJECTION,                               // The columns to return
//                null,                                // The columns for the WHERE clause
//                null,                            // The values for the WHERE clause
//                null,                                     // don't group the rows
//                null,                                     // don't filter by row groups
//                null                                 // The sort order
//        );
//
//        List<Transaction> transactions = new ArrayList<>();
//        while (cursor.moveToNext()) {
//            transactions.add(readTransaction(cursor));
//        }
//        cursor.close();
//        return transactions;
//    }
//
//    private Transaction readTransaction(Cursor cursor) {
//        long id = cursor.getLong(cursor.getColumnIndexOrThrow(BudgetEntry._ID));
//        String details =
//                cursor.getString(cursor.getColumnIndexOrThrow(BudgetEntry.COLUMN_NAME_DETAILS));
//        Double sum =
//                cursor.getDouble(cursor.getColumnIndexOrThrow(BudgetEntry.COLUMN_NAME_SUM));
//        return new Transaction(id, sum, details);
//    }
////
////    public void delete(long id) {
////        SQLiteDatabase db = dbHelper.getWritableDatabase();
////
////        String selection = BudgetEntry._ID + " = ?";
////        String[] args = {String.valueOf(id)};
////
////        db.delete(BudgetEntry.TABLE_NAME, selection, args);
////    }
//
//    public void close() {
//        dbHelper.close();
//    }
//
//    public Transaction getById(long id) {
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        String selection = BudgetEntry._ID + " = ?";
//        String[] args = {String.valueOf(id)};
//
//        Cursor cursor = db.query(
//                BudgetEntry.TABLE_NAME,                     // The table to query
//                TRANSACTION_PROJECTION,                               // The columns to return
//                selection,                                // The columns for the WHERE clause
//                args,                            // The values for the WHERE clause
//                null,                                     // don't group the rows
//                null,                                     // don't filter by row groups
//                null                                 // The sort order
//        );
//
//        if (cursor.moveToNext()) {
//            return readTransaction(cursor);
//        }
//        return null;
//    }
}
