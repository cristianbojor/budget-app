package com.fbojor.college.budget.model.db;

import android.provider.BaseColumns;

/**
 * Created by fbojor on 18.01.2017.
 */

public class BudgetContract {
    private BudgetContract() {
    }

    public static class BudgetEntry implements BaseColumns {
        public static final String TABLE_NAME = "transactions";
        public static final String COLUMN_NAME_SUM = "sum";
        public static final String COLUMN_NAME_DETAILS = "details";
    }

}

