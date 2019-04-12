package com.example.minchilow.ipss;

import android.provider.BaseColumns;

import java.util.Date;

public class ResultHistory {

    public ResultHistory() {

    }

    public static final class ResultDetail implements BaseColumns {
        public static final String TABLE_NAME = "rhistory";
        public static final String COLUMN_EMAIL_NO = "email_no";
        public static final String COLUMN_RESULT = "result";
        public static final String COLUMN_DATE = "date";
    }

}
