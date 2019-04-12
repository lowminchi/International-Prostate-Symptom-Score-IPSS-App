package com.example.minchilow.ipss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Question5Activity extends AppCompatActivity {
    Button btn_que5_no1,btn_que5_no2,btn_que5_no3,btn_que5_no4,btn_que5_no5,btn_que5_no6;

    int q1;
    int q2;
    int q3;
    int q4;
    int q5=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_que5_no1=(Button)findViewById(R.id.btn_que5_no1);
        btn_que5_no2=(Button)findViewById(R.id.btn_que5_no2);
        btn_que5_no3=(Button)findViewById(R.id.btn_que5_no3);
        btn_que5_no4=(Button)findViewById(R.id.btn_que5_no4);
        btn_que5_no5=(Button)findViewById(R.id.btn_que5_no5);
        btn_que5_no6=(Button)findViewById(R.id.btn_que5_no6);

        Intent intent = getIntent();
        q1 = intent.getIntExtra("Q1",0);
        q2 = intent.getIntExtra("Q2",0);
        q3 = intent.getIntExtra("Q3",0);
        q4 = intent.getIntExtra("Q4",0);
        int total = q1+q2+q3+q4;
        Toast.makeText(this,"Current Score: "+total,Toast.LENGTH_LONG).show();

        btn_que5_no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q5 = 0;
                Intent intent5=new Intent(Question5Activity.this,Question6Activity.class);
                intent5.putExtra("Q1", q1);
                intent5.putExtra("Q2", q2);
                intent5.putExtra("Q3", q3);
                intent5.putExtra("Q4", q4);
                intent5.putExtra("Q5", q5);
                startActivity(intent5);
            }
        });

        btn_que5_no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q5 = 1;
                Intent intent5=new Intent(Question5Activity.this,Question6Activity.class);
                intent5.putExtra("Q1", q1);
                intent5.putExtra("Q2", q2);
                intent5.putExtra("Q3", q3);
                intent5.putExtra("Q4", q4);
                intent5.putExtra("Q5", q5);
                startActivity(intent5);
            }
        });

        btn_que5_no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q5 = 2;
                Intent intent5=new Intent(Question5Activity.this,Question6Activity.class);
                intent5.putExtra("Q1", q1);
                intent5.putExtra("Q2", q2);
                intent5.putExtra("Q3", q3);
                intent5.putExtra("Q4", q4);
                intent5.putExtra("Q5", q5);
                startActivity(intent5);
            }
        });

        btn_que5_no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q5 = 3;
                Intent intent5=new Intent(Question5Activity.this,Question6Activity.class);
                intent5.putExtra("Q1", q1);
                intent5.putExtra("Q2", q2);
                intent5.putExtra("Q3", q3);
                intent5.putExtra("Q4", q4);
                intent5.putExtra("Q5", q5);
                startActivity(intent5);
            }
        });

        btn_que5_no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q5 = 4;
                Intent intent5=new Intent(Question5Activity.this,Question6Activity.class);
                intent5.putExtra("Q1", q1);
                intent5.putExtra("Q2", q2);
                intent5.putExtra("Q3", q3);
                intent5.putExtra("Q4", q4);
                intent5.putExtra("Q5", q5);
                startActivity(intent5);
            }
        });

        btn_que5_no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q5 = 5;
                Intent intent5=new Intent(Question5Activity.this,Question6Activity.class);
                intent5.putExtra("Q1", q1);
                intent5.putExtra("Q2", q2);
                intent5.putExtra("Q3", q3);
                intent5.putExtra("Q4", q4);
                intent5.putExtra("Q5", q5);
                startActivity(intent5);
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
            Intent intent = new Intent(Question5Activity.this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
