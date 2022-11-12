package com.scorpion.healingland;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.scorpion.healingland.Database.DBHandler;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextInputEditText username, password;
    TextView errorMsg;
    boolean status = false;
    String send;

    // back button
    private static final int TIME_INTERVAL = 2000;
    private long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        errorMsg = findViewById(R.id.error);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.signInButton);

        send = username.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());

                if ((username.getText().toString().isEmpty()) && (password.getText().toString().isEmpty())) {
                    errorMsg.setText("* Fill Username and Password");
                } else if ((username.getText().toString().isEmpty()) && !(password.getText().toString().isEmpty())) {
                    errorMsg.setText("* Fill Username");
                } else if (!(username.getText().toString().isEmpty()) && (password.getText().toString().isEmpty())) {
                    errorMsg.setText("* Fill Password");
                } else {
                    try {
                        status = dbHandler.userLogin(username.getText().toString(), password.getText().toString());

                    } catch (Exception e) {
                        // something Went Wrong
                        errorMsg.setText("* Something went wrong!");
                    }

                    // checking the login status
                    if (status) {
                        Toast.makeText(LoginActivity.this, "User Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        i.putExtra("email", send);
                        startActivity(i);
                        finish();
                    } else {
                        errorMsg.setText("* Username or Password Incorrect");
                    }

                }
            }
        });
    }

    public void navigateRegister(View view) {
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
       if(backPressed + TIME_INTERVAL > System.currentTimeMillis()){
           super.onBackPressed();
           return;
       } else {
           Toast.makeText(LoginActivity.this, "Press Back Again to Exit!", Toast.LENGTH_SHORT).show();
       }
       backPressed = System.currentTimeMillis();
    }
}