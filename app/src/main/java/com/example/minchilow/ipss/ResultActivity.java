package com.example.minchilow.ipss;


import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {
    int q1;
    int q2;
    int q3;
    int q4;
    int q5;
    int q6;
    int q7=0;

    String m1,m01,m2,m02,m3,m03,str1,str2;

    private FirebaseAuth firebaseAuth;

    TextView txtResult,txtScale1,txtScale2,txtScale3,txtAdvice;

    ResultDBHelper mResultDBHelper;
    SQLiteDatabase db;

    String emailno, result, datenow;

    Button btn;

    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResultDBHelper = new ResultDBHelper(this);
        db = mResultDBHelper.getWritableDatabase();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtResult=(TextView)findViewById(R.id.txt_result);
        txtScale1=(TextView)findViewById(R.id.txt_scale1);
        txtScale2=(TextView)findViewById(R.id.txt_scale2);
        txtScale2=(TextView)findViewById(R.id.txt_scale3);
        txtAdvice=(TextView)findViewById(R.id.txt_advice);
        btn = (Button) findViewById(R.id.btn_save);

        Intent intent = getIntent();
        q1 = intent.getIntExtra("Q1",0);
        q2 = intent.getIntExtra("Q2",0);
        q3 = intent.getIntExtra("Q3",0);
        q4 = intent.getIntExtra("Q4",0);
        q5 = intent.getIntExtra("Q5",0);
        q6 = intent.getIntExtra("Q6",0);
        q7 = intent.getIntExtra("Q7",0);

        total = q1+q2+q3+q4+q5+q6+q7;
        txtResult.append(" "+total);

        if (((getResources().getConfiguration().locale).toString()).equals("en_US")  || ((getResources().getConfiguration().locale).toString()).equals("en_us")){
            str1 = "Warning";
            str2 = "Do you want to save this result?";
            m01 = "Mild";
            m02 = ("Severe");
            m03 = ("Moderate");
            m1 = ("Your I-PSS total score is "+total+" thus your level is mild. You are healthy but please having more awareness towards this problem also. \nKeep in Mind: Prevention always better than Cure");
            m2 = ("Your I-PSS total score is "+total+" thus your level is severe. Please go to visit the hospital nearby to get rid of this problem.");
            m3 = ("Your I-PSS total score is "+total+" thus your level is moderate. Please having more awareness towards this problem.");
        }
        else if (getResources().getConfiguration().locale.toString().equals("zh")){
            str1 = "警告";
            str2 = "是否储存记录？";
            m01 = ("轻微");
            m02 = ("严重");
            m03 = ("中等");
            m1 = ("你的I-PSS总分是 "+total+" 因此你的水平是温和的，你是健康的，但是请你对这个问题有更多的认识。\n记住：预防总是胜过治疗.");
            m2 = ("你的I-PSS总分是 "+total+" 因此你的水平很严重，请到附近的医院去解决这个问题.");
            m3 = ("你的I-PSS总分是 "+total+" 因此你的水平适中，请对这个问题有更多的认识.");
        }
        else if (getResources().getConfiguration().locale.toString().equals("ms")){
            str1 = "Amaran";
            str2 = "Adakah anda mahu simpan keputusan ini?";
            m01 = ("Ringan");
            m02 = ("Teruk");
            m03 = ("Sederhana");
            m1 = ("Jumlah skor I-PSS anda ialah "+total+" Anda sihat tetapi sila mengambil berat tentang penyakit ini. \nSentiasa Ingat: Pencegahan sentiasa paling baik.");
            m2 = ("Jumlah skor I-PSS anda ialah "+total+" Tahap anda amat serious. Sila pergi ke hospital.");
            m3 = ("Jumlah skor I-PSS anda ialah "+total+" Tahap anda sederhana tetapi sila jaga kesihatan diri lebih baik lagi.");
        }

        infoDialog(total);
        //Toast.makeText(this,""+total,Toast.LENGTH_LONG).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseAuth = FirebaseAuth.getInstance();
                if (firebaseAuth.getCurrentUser() == null) {
                    finish();
                    startActivity(new Intent(ResultActivity.this, LoginActivity.class));
                }

                Date date = new Date();

                FirebaseUser user = firebaseAuth.getCurrentUser();
                emailno = user.getEmail().toString();
                result = String.valueOf(total);
                datenow = DateFormat.getDateTimeInstance().format(date).toString();

                //create a new map of value where column name are the key
                ContentValues values = new ContentValues();
                values.put(ResultHistory.ResultDetail.COLUMN_EMAIL_NO, emailno);
                values.put(ResultHistory.ResultDetail.COLUMN_RESULT, result);
                values.put(ResultHistory.ResultDetail.COLUMN_DATE, datenow);

                //create data insert function
                insertData(db, values);

                Intent intent = new Intent(ResultActivity.this, ProfileActivity.class);
                startActivity(intent);

            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(ResultActivity.this);
            mBuilder.setTitle(str1);
            mBuilder.setMessage(str2);

            mBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    firebaseAuth = FirebaseAuth.getInstance();
                    if (firebaseAuth.getCurrentUser() == null) {
                        finish();
                        startActivity(new Intent(ResultActivity.this, LoginActivity.class));
                    }

                    Date date = new Date();

                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    emailno = user.getEmail().toString();
                    result = String.valueOf(total);
                    datenow = DateFormat.getDateTimeInstance().format(date).toString();

                    //create a new map of value where column name are the key
                    ContentValues values = new ContentValues();
                    values.put(ResultHistory.ResultDetail.COLUMN_EMAIL_NO, emailno);
                    values.put(ResultHistory.ResultDetail.COLUMN_RESULT, result);
                    values.put(ResultHistory.ResultDetail.COLUMN_DATE, datenow);

                    //create data insert function
                    insertData(db, values);

                    Intent intent = new Intent(ResultActivity.this, ProfileActivity.class);
                    startActivity(intent);

                    dialogInterface.dismiss();

                    ResultActivity.this.finish();
                }
            });

            mBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(ResultActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    dialogInterface.dismiss();

                    ResultActivity.this.finish();
                }
            });

            AlertDialog mDialog = mBuilder.create();
            mDialog.show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void insertData(SQLiteDatabase db,ContentValues values)
    {
        long newRowId;
        newRowId = db.insert(ResultHistory.ResultDetail.TABLE_NAME, null, values);

        //if data is inserted then toast a message
        if (newRowId != -1) {
            Message.message(ResultActivity.this, "Record Saved");

        }
    }

    public void infoDialog (int total) {
        if (total <= 7) {
            AlertDialog alertDialog = new AlertDialog.Builder(ResultActivity.this).create();
            alertDialog.setTitle(m01);
            alertDialog.setMessage(m1);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        else if (total > 18) {
            AlertDialog alertDialog = new AlertDialog.Builder(ResultActivity.this).create();
            alertDialog.setTitle(m02);
            alertDialog.setMessage(m2);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        else {
            AlertDialog alertDialog = new AlertDialog.Builder(ResultActivity.this).create();
            alertDialog.setTitle(m03);
            alertDialog.setMessage(m3);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

}
