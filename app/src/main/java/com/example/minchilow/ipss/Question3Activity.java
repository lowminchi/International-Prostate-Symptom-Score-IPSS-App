package com.example.minchilow.ipss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question3Activity extends AppCompatActivity {
    Button btn_que3_no1,btn_que3_no2,btn_que3_no3,btn_que3_no4,btn_que3_no5,btn_que3_no6;

    int q1;
    int q2;
    int q3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_que3_no1=(Button)findViewById(R.id.btn_que3_no1);
        btn_que3_no2=(Button)findViewById(R.id.btn_que3_no2);
        btn_que3_no3=(Button)findViewById(R.id.btn_que3_no3);
        btn_que3_no4=(Button)findViewById(R.id.btn_que3_no4);
        btn_que3_no5=(Button)findViewById(R.id.btn_que3_no5);
        btn_que3_no6=(Button)findViewById(R.id.btn_que3_no6);

        Intent intent = getIntent();
        q1 = intent.getIntExtra("Q1",0);
        q2 = intent.getIntExtra("Q2",0);
        int total = q1+q2;
        Toast.makeText(this,"Current Score: "+total, Toast.LENGTH_LONG).show();

        btn_que3_no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3 = 0;
                Intent intent3=new Intent(Question3Activity.this,Question4Activity.class);
                intent3.putExtra("Q1", q1);
                intent3.putExtra("Q2", q2);
                intent3.putExtra("Q3", q3);
                startActivity(intent3);
            }
        });

        btn_que3_no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3 = 1;
                Intent intent3=new Intent(Question3Activity.this,Question4Activity.class);
                intent3.putExtra("Q1", q1);
                intent3.putExtra("Q2", q2);
                intent3.putExtra("Q3", q3);
                startActivity(intent3);
            }
        });

        btn_que3_no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3 = 2;
                Intent intent3=new Intent(Question3Activity.this,Question4Activity.class);
                intent3.putExtra("Q1", q1);
                intent3.putExtra("Q2", q2);
                intent3.putExtra("Q3", q3);
                startActivity(intent3);
            }
        });

        btn_que3_no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3 = 3;
                Intent intent3=new Intent(Question3Activity.this,Question4Activity.class);
                intent3.putExtra("Q1", q1);
                intent3.putExtra("Q2", q2);
                intent3.putExtra("Q3", q3);
                startActivity(intent3);
            }
        });

        btn_que3_no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3 = 4;
                Intent intent3=new Intent(Question3Activity.this,Question4Activity.class);
                intent3.putExtra("Q1", q1);
                intent3.putExtra("Q2", q2);
                intent3.putExtra("Q3", q3);
                startActivity(intent3);
            }
        });

        btn_que3_no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3 = 5;
                Intent intent3=new Intent(Question3Activity.this,Question4Activity.class);
                intent3.putExtra("Q1", q1);
                intent3.putExtra("Q2", q2);
                intent3.putExtra("Q3", q3);
                startActivity(intent3);
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
            Intent intent = new Intent(Question3Activity.this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
