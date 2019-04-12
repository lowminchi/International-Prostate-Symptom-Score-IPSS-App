package com.example.minchilow.ipss;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Date;

public class HistoryOfResult extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    String emailno;

    ResultDBHelper mResultDBHelper;
    SQLiteDatabase db;

    ListView lv_result;

    ArrayList<String> resultInfor;
    // define which columns want to return
    private String[] allColumns = {ResultHistory.ResultDetail._ID, ResultHistory.ResultDetail.COLUMN_EMAIL_NO,
            ResultHistory.ResultDetail.COLUMN_RESULT, ResultHistory.ResultDetail.COLUMN_DATE};

    protected void onResume() {
        super.onResume();
        loadData();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_of_result);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(HistoryOfResult.this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        emailno = user.getEmail().toString();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mResultDBHelper = new ResultDBHelper(this);
        db = mResultDBHelper.getWritableDatabase();

        lv_result = (ListView) findViewById(R.id.lv_result);
    }

    public void loadData() {
        resultInfor = new ArrayList<String>();

        Cursor cursor = db.query(ResultHistory.ResultDetail.TABLE_NAME, //Table
                allColumns, //The columns to return
                null,//The columns for the WHERE clause
                null, //The values for the WHERE clause
                null,// don't group the rows
                null, //don't filter by row groups
                null,//The sort order
                null);//Limits the number of rows returned by the query
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            if (emailno.equals(cursor.getString(1))) {
                resultInfor.add(cursor.getString(0) + ". Email No.: "
                        + cursor.getString(1) + " Result: "
                        + cursor.getString(2) + " Date: "
                        + cursor.getString(3));
            }
            cursor.moveToNext();
        }

        //array adapter for the single list view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(HistoryOfResult.this, android.R.layout.simple_list_item_1, resultInfor);

        lv_result.setAdapter(adapter);
        cursor.close();

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {

            this.finish();
            Intent intent = new Intent(HistoryOfResult.this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
