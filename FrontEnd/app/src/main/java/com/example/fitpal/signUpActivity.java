package com.example.fitpal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.AsyncTask;
import android.widget.Toast;
import java.util.HashMap;


import java.util.HashMap;

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
    String F_Name_Holder, L_Name_Holder, EmailHolder, PasswordHolder;
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    String finalResult ;
    String HttpURL = "http://localhost/phpmyadmin/index.php?route=/table/structure&db=fitpal&table=user";
    HttpParse httpParse = new HttpParse();



    public void CheckEditTextIsEmptyOrNot(){

        F_Name_Holder = fname.getText().toString();
        L_Name_Holder = lname.getText().toString();
        EmailHolder = email.getText().toString();
        PasswordHolder = password.getText().toString();


        if(TextUtils.isEmpty(F_Name_Holder) || TextUtils.isEmpty(L_Name_Holder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {
            CheckEditText = false;
        }
        else {
            CheckEditText = true ;
        }

    }

    public void UserRegisterFunction(final String F_Name, final String L_Name, final String email, final String password){

        class UserRegisterFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(signUpActivity.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                Toast.makeText(signUpActivity.this,httpResponseMsg.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("f_name",params[0]);

                hashMap.put("L_name",params[1]);

                hashMap.put("email",params[2]);

                hashMap.put("password",params[3]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserRegisterFunctionClass userRegisterFunctionClass = new UserRegisterFunctionClass();

        userRegisterFunctionClass.execute(F_Name,L_Name,email,password);
    }

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

        fname = (EditText) findViewById(R.id.fName);
        lname = (EditText) findViewById(R.id.lname);
        pnumber = (EditText) findViewById(R.id.pnumber);
        email = (EditText) findViewById(R.id.e_mail);
        username = (EditText) findViewById(R.id.username_sign);
        password = (EditText) findViewById(R.id.password_sign);
        c_password = (EditText) findViewById(R.id.password_conf_sign);
    }


}