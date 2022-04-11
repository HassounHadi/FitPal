package com.example.fitpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class homeActivity extends AppCompatActivity {

    TextView reserve;
    TextView trainers;
    TextView goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        reserve = (TextView) findViewById(R.id.btn1_text);
        trainers = (TextView) findViewById(R.id.btn2_text);
        goal = (TextView) findViewById(R.id.btn3_text);

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity.this, reserveActivity.class);
                startActivity(intent);
            }
        });

        trainers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity.this, trainerActivity.class);
                startActivity(intent);
            }
        });


        goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity.this, goalActivity.class);
                startActivity(intent);
            }
        });
    }
}