package com.example.fitpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class profilePage extends AppCompatActivity {

    ImageView logo;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        logo = (ImageView) findViewById(R.id.logo_btn);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profilePage.this ,homeActivity.class);
                startActivity(intent);
            }
        });

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profilePage.this, logInActivity.class);
                startActivity(intent);
            }
        });
    }
}