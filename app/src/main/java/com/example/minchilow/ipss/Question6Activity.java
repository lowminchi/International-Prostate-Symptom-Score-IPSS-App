package com.example.minchilow.ipss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question6Activity extends AppCompatActivity {
    Button btn_que6_no1,btn_que6_no2,btn_que6_no3,btn_que6_no4,btn_que6_no5,btn_que6_no6;

    int q1;
    int q2;
    int q3;
    int q4;
    int q5;
    int q6=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_que6_no1=(Button)findViewById(R.id.btn_que6_no1);
        btn_que6_no2=(Button)findViewById(R.id.btn_que6_no2);
        btn_que6_no3=(Button)findViewById(R.id.btn_que6_no3);
        btn_que6_no4=(Button)findViewById(R.id.btn_que6_no4);
        btn_que6_no5=(Button)findViewById(R.id.btn_que6_no5);
        btn_que6_no6=(Button)findViewById(R.id.btn_que6_no6);

        Intent intent = getIntent();
        q1 = intent.getIntExtra("Q1",0);
        q2 = intent.getIntExtra("Q2",0);
        q3 = intent.getIntExtra("Q3",0);
        q4 = intent.getIntExtra("Q4",0);
        q5 = intent.getIntExtra("Q5",0);
        int total = q1+q2+q3+q4+q5;
        Toast.makeText(this,"Current Score: "+total,Toast.LENGTH_LONG).show();

        btn_que6_no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q6 = 0;
                Intent intent6=new Intent(Question6Activity.this,Question7Activity.class);
                intent6.putExtra("Q1", q1);
                intent6.putExtra("Q2", q2);
                intent6.putExtra("Q3", q3);
                intent6.putExtra("Q4", q4);
                intent6.putExtra("Q5", q5);
                intent6.putExtra("Q6", q6);
                startActivity(intent6);
            }
        });

        btn_que6_no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q6 = 1;
                Intent intent6=new Intent(Question6Activity.this,Question7Activity.class);
                intent6.putExtra("Q1", q1);
                intent6.putExtra("Q2", q2);
                intent6.putExtra("Q3", q3);
                intent6.putExtra("Q4", q4);
                intent6.putExtra("Q5", q5);
                intent6.putExtra("Q6", q6);
                startActivity(intent6);
            }
        });

        btn_que6_no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q6 = 2;
                Intent intent6=new Intent(Question6Activity.this,Question7Activity.class);
                intent6.putExtra("Q1", q1);
                intent6.putExtra("Q2", q2);
                intent6.putExtra("Q3", q3);
                intent6.putExtra("Q4", q4);
                intent6.putExtra("Q5", q5);
                intent6.putExtra("Q6", q6);
                startActivity(intent6);
            }
        });

        btn_que6_no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q6 = 3;
                Intent intent6=new Intent(Question6Activity.this,Question7Activity.class);
                intent6.putExtra("Q1", q1);
                intent6.putExtra("Q2", q2);
                intent6.putExtra("Q3", q3);
                intent6.putExtra("Q4", q4);
                intent6.putExtra("Q5", q5);
                intent6.putExtra("Q6", q6);
                startActivity(intent6);
            }
        });

        btn_que6_no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q6 = 4;
                Intent intent6=new Intent(Question6Activity.this,Question7Activity.class);
                intent6.putExtra("Q1", q1);
                intent6.putExtra("Q2", q2);
                intent6.putExtra("Q3", q3);
                intent6.putExtra("Q4", q4);
                intent6.putExtra("Q5", q5);
                intent6.putExtra("Q6", q6);
                startActivity(intent6);
            }
        });

        btn_que6_no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q6 = 5;
                Intent intent6=new Intent(Question6Activity.this,Question7Activity.class);
                intent6.putExtra("Q1", q1);
                intent6.putExtra("Q2", q2);
                intent6.putExtra("Q3", q3);
                intent6.putExtra("Q4", q4);
                intent6.putExtra("Q5", q5);
                intent6.putExtra("Q6", q6);
                startActivity(intent6);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
            Intent intent = new Intent(Question6Activity.this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
