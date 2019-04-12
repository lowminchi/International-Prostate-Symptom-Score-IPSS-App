package com.example.minchilow.ipss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question4Activity extends AppCompatActivity {
    Button btn_que4_no1,btn_que4_no2,btn_que4_no3,btn_que4_no4,btn_que4_no5,btn_que4_no6;

    int q1;
    int q2;
    int q3;
    int q4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_que4_no1=(Button)findViewById(R.id.btn_que4_no1);
        btn_que4_no2=(Button)findViewById(R.id.btn_que4_no2);
        btn_que4_no3=(Button)findViewById(R.id.btn_que4_no3);
        btn_que4_no4=(Button)findViewById(R.id.btn_que4_no4);
        btn_que4_no5=(Button)findViewById(R.id.btn_que4_no5);
        btn_que4_no6=(Button)findViewById(R.id.btn_que4_no6);

        Intent intent = getIntent();
        q1 = intent.getIntExtra("Q1",0);
        q2 = intent.getIntExtra("Q2",0);
        q3 = intent.getIntExtra("Q3",0);
        int total = q1+q2+q3;
        Toast.makeText(this,"Current Score: "+total,Toast.LENGTH_LONG).show();

        btn_que4_no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q4 = 0;
                Intent intent4=new Intent(Question4Activity.this,Question5Activity.class);
                intent4.putExtra("Q1", q1);
                intent4.putExtra("Q2", q2);
                intent4.putExtra("Q3", q3);
                intent4.putExtra("Q4", q4);
                startActivity(intent4);
            }
        });

        btn_que4_no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q4 = 1;
                Intent intent4=new Intent(Question4Activity.this,Question5Activity.class);
                intent4.putExtra("Q1", q1);
                intent4.putExtra("Q2", q2);
                intent4.putExtra("Q3", q3);
                intent4.putExtra("Q4", q4);
                startActivity(intent4);
            }
        });

        btn_que4_no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q4 = 2;
                Intent intent4=new Intent(Question4Activity.this,Question5Activity.class);
                intent4.putExtra("Q1", q1);
                intent4.putExtra("Q2", q2);
                intent4.putExtra("Q3", q3);
                intent4.putExtra("Q4", q4);
                startActivity(intent4);
            }
        });

        btn_que4_no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q4 = 3;
                Intent intent4=new Intent(Question4Activity.this,Question5Activity.class);
                intent4.putExtra("Q1", q1);
                intent4.putExtra("Q2", q2);
                intent4.putExtra("Q3", q3);
                intent4.putExtra("Q4", q4);
                startActivity(intent4);
            }
        });

        btn_que4_no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q4 = 4;
                Intent intent4=new Intent(Question4Activity.this,Question5Activity.class);
                intent4.putExtra("Q1", q1);
                intent4.putExtra("Q2", q2);
                intent4.putExtra("Q3", q3);
                intent4.putExtra("Q4", q4);
                startActivity(intent4);
            }
        });

        btn_que4_no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q4 = 5;
                Intent intent4=new Intent(Question4Activity.this,Question5Activity.class);
                intent4.putExtra("Q1", q1);
                intent4.putExtra("Q2", q2);
                intent4.putExtra("Q3", q3);
                intent4.putExtra("Q4", q4);
                startActivity(intent4);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
            Intent intent = new Intent(Question4Activity.this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
