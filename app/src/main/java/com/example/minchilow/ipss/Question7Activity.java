package com.example.minchilow.ipss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question7Activity extends AppCompatActivity {
    Button btn_que7_no1,btn_que7_no2,btn_que7_no3,btn_que7_no4,btn_que7_no5,btn_que7_no6;

    int q1;
    int q2;
    int q3;
    int q4;
    int q5;
    int q6;
    int q7=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_que7_no1=(Button)findViewById(R.id.btn_que7_no1);
        btn_que7_no2=(Button)findViewById(R.id.btn_que7_no2);
        btn_que7_no3=(Button)findViewById(R.id.btn_que7_no3);
        btn_que7_no4=(Button)findViewById(R.id.btn_que7_no4);
        btn_que7_no5=(Button)findViewById(R.id.btn_que7_no5);
        btn_que7_no6=(Button)findViewById(R.id.btn_que7_no6);

        Intent intent = getIntent();
        q1 = intent.getIntExtra("Q1",0);
        q2 = intent.getIntExtra("Q2",0);
        q3 = intent.getIntExtra("Q3",0);
        q4 = intent.getIntExtra("Q4",0);
        q5 = intent.getIntExtra("Q5",0);
        q6 = intent.getIntExtra("Q6",0);
        int total = q1+q2+q3+q4+q5+q6;
        Toast.makeText(this,"Current Score: "+total,Toast.LENGTH_LONG).show();

        btn_que7_no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q7 = 0;
                Intent intent7=new Intent(Question7Activity.this,ResultActivity.class);
                intent7.putExtra("Q1", q1);
                intent7.putExtra("Q2", q2);
                intent7.putExtra("Q3", q3);
                intent7.putExtra("Q4", q4);
                intent7.putExtra("Q5", q5);
                intent7.putExtra("Q6", q6);
                intent7.putExtra("Q7", q7);
                startActivity(intent7);
            }
        });

        btn_que7_no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q7 = 1;
                Intent intent7=new Intent(Question7Activity.this,ResultActivity.class);
                intent7.putExtra("Q1", q1);
                intent7.putExtra("Q2", q2);
                intent7.putExtra("Q3", q3);
                intent7.putExtra("Q4", q4);
                intent7.putExtra("Q5", q5);
                intent7.putExtra("Q6", q6);
                intent7.putExtra("Q7", q7);
                startActivity(intent7);
            }
        });

        btn_que7_no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q7 = 2;
                Intent intent7=new Intent(Question7Activity.this,ResultActivity.class);
                intent7.putExtra("Q1", q1);
                intent7.putExtra("Q2", q2);
                intent7.putExtra("Q3", q3);
                intent7.putExtra("Q4", q4);
                intent7.putExtra("Q5", q5);
                intent7.putExtra("Q6", q6);
                intent7.putExtra("Q7", q7);
                startActivity(intent7);
            }
        });

        btn_que7_no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q7 = 3;
                Intent intent7=new Intent(Question7Activity.this,ResultActivity.class);
                intent7.putExtra("Q1", q1);
                intent7.putExtra("Q2", q2);
                intent7.putExtra("Q3", q3);
                intent7.putExtra("Q4", q4);
                intent7.putExtra("Q5", q5);
                intent7.putExtra("Q6", q6);
                intent7.putExtra("Q7", q7);
                startActivity(intent7);
            }
        });

        btn_que7_no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q7 = 4;
                Intent intent7=new Intent(Question7Activity.this,ResultActivity.class);
                intent7.putExtra("Q1", q1);
                intent7.putExtra("Q2", q2);
                intent7.putExtra("Q3", q3);
                intent7.putExtra("Q4", q4);
                intent7.putExtra("Q5", q5);
                intent7.putExtra("Q6", q6);
                intent7.putExtra("Q7", q7);
                startActivity(intent7);
            }
        });

        btn_que7_no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q7 = 5;
                Intent intent7=new Intent(Question7Activity.this,ResultActivity.class);
                intent7.putExtra("Q1", q1);
                intent7.putExtra("Q2", q2);
                intent7.putExtra("Q3", q3);
                intent7.putExtra("Q4", q4);
                intent7.putExtra("Q5", q5);
                intent7.putExtra("Q6", q6);
                intent7.putExtra("Q7", q7);
                startActivity(intent7);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
            Intent intent = new Intent(Question7Activity.this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
