package com.example.fitpal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signUpActivity extends AppCompatActivity {
    Button button;
    TextView text;
    EditText fname;
    EditText lname;
    EditText pnumber;
    EditText email;
    EditText username;
    EditText password;
    EditText c_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        button = (Button) findViewById(R.id.signup_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUpActivity.this, logInActivity.class);
                startActivity(intent);
            }
        });

        text = (TextView) findViewById(R.id.logIN);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUpActivity.this, logInActivity.class);
                startActivity(intent);
            }
        });
    }
}