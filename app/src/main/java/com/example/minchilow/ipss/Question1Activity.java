package com.example.minchilow.ipss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Question1Activity extends AppCompatActivity {
    Button btn_que1_no1,btn_que1_no2,btn_que1_no3,btn_que1_no4,btn_que1_no5,btn_que1_no6;

    int q1 = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_que1_no1=(Button)findViewById(R.id.btn_que1_no1);
        btn_que1_no2=(Button)findViewById(R.id.btn_que1_no2);
        btn_que1_no3=(Button)findViewById(R.id.btn_que1_no3);
        btn_que1_no4=(Button)findViewById(R.id.btn_que1_no4);
        btn_que1_no5=(Button)findViewById(R.id.btn_que1_no5);
        btn_que1_no6=(Button)findViewById(R.id.btn_que1_no6);

        btn_que1_no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1 = 0;
                Intent intent1=new Intent(Question1Activity.this,Question2Activity.class);
                intent1.putExtra("Q1", q1);
                startActivity(intent1);

            }
        });

        btn_que1_no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1 = 1;
                Intent intent1=new Intent(Question1Activity.this,Question2Activity.class);
                intent1.putExtra("Q1", q1);
                startActivity(intent1);

            }
        });

        btn_que1_no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1 = 2;
                Intent intent1=new Intent(Question1Activity.this,Question2Activity.class);
                intent1.putExtra("Q1", q1);
                startActivity(intent1);

            }
        });

        btn_que1_no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1 = 3;
                Intent intent1=new Intent(Question1Activity.this,Question2Activity.class);
                intent1.putExtra("Q1", q1);
                startActivity(intent1);

            }
        });

        btn_que1_no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1 = 4;
                Intent intent1=new Intent(Question1Activity.this,Question2Activity.class);
                intent1.putExtra("Q1", q1);
                startActivity(intent1);

            }
        });

        btn_que1_no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1 = 5;
                Intent intent1=new Intent(Question1Activity.this,Question2Activity.class);
                intent1.putExtra("Q1", q1);
                startActivity(intent1);

            }
        });


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
            Intent intent = new Intent(Question1Activity.this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
