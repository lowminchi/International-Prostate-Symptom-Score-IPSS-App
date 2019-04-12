package com.example.minchilow.ipss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question2Activity extends AppCompatActivity {
    Button btn_que2_no1,btn_que2_no2,btn_que2_no3,btn_que2_no4,btn_que2_no5,btn_que2_no6;

    //int score2;
    int q1;
    int q2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_que2_no1=(Button)findViewById(R.id.btn_que2_no1);
        btn_que2_no2=(Button)findViewById(R.id.btn_que2_no2);
        btn_que2_no3=(Button)findViewById(R.id.btn_que2_no3);
        btn_que2_no4=(Button)findViewById(R.id.btn_que2_no4);
        btn_que2_no5=(Button)findViewById(R.id.btn_que2_no5);
        btn_que2_no6=(Button)findViewById(R.id.btn_que2_no6);

        Intent intent = getIntent();
        q1 = intent.getIntExtra("Q1",0);
        Toast.makeText(this,"Current Score: "+q1, Toast.LENGTH_LONG).show();

        btn_que2_no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2 = 0;
                Intent intent2=new Intent(Question2Activity.this,Question3Activity.class);
                intent2.putExtra("Q1", q1);
                intent2.putExtra("Q2", q2);
                startActivity(intent2);

            }
        });

        btn_que2_no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2 = 1;
                Intent intent2=new Intent(Question2Activity.this,Question3Activity.class);
                intent2.putExtra("Q1", q1);
                intent2.putExtra("Q2", q2);
                startActivity(intent2);
            }
        });

        btn_que2_no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2 = 2;
                Intent intent2=new Intent(Question2Activity.this,Question3Activity.class);
                intent2.putExtra("Q1", q1);
                intent2.putExtra("Q2", q2);
                startActivity(intent2);
            }
        });

        btn_que2_no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2 = 3;
                Intent intent2=new Intent(Question2Activity.this,Question3Activity.class);
                intent2.putExtra("Q1", q1);
                intent2.putExtra("Q2", q2);
                startActivity(intent2);
            }
        });

        btn_que2_no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2 = 4;
                Intent intent2=new Intent(Question2Activity.this,Question3Activity.class);
                intent2.putExtra("Q1", q1);
                intent2.putExtra("Q2", q2);
                startActivity(intent2);;
            }
        });

        btn_que2_no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2 = 5;
                Intent intent2=new Intent(Question2Activity.this,Question3Activity.class);
                intent2.putExtra("Q1", q1);
                intent2.putExtra("Q2", q2);
                startActivity(intent2);
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
            Intent intent = new Intent(Question2Activity.this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
