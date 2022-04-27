package com.example.fitpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class goalActivity extends AppCompatActivity {

    private Spinner spinner1;
    Button button;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan);

        spinner1 = findViewById(R.id.spinner_goal);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.goal, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        button = (Button) findViewById(R.id.plan);
         button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "You will receive your plan via email between 1 or 3 days." , Toast.LENGTH_LONG).show();
            }
        });

         logo = (ImageView) findViewById(R.id.logo_btn);
         logo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(goalActivity.this, homeActivity.class);
                 startActivity(intent);
             }
         });
    }
}