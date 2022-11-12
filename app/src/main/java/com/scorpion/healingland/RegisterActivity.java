package com.scorpion.healingland;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.scorpion.healingland.Database.DBHandler;

public class RegisterActivity extends AppCompatActivity {

    TextView errorMsg;
    EditText firstname, lastname, email, phone, password, confirmPassword;
    Button register;
    String send;
    boolean status;

    // back button
    private static final int TIME_INTERVAL = 2000;
    private long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        errorMsg = findViewById(R.id.errorMsg);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.telephone);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        register = findViewById(R.id.register);

        send = email.getText().toString();

        register.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (firstname.getText().toString().isEmpty() || lastname.getText().toString().isEmpty() || email.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || password.getText().toString().isEmpty() || confirmPassword.getText().toString().isEmpty()) {
                    errorMsg.setText("* All the fields are required");
                } else {
                    if (password.getText().toString().equals(confirmPassword.getText().toString())) {
                        DBHandler dbHandler = new DBHandler(getApplicationContext());
                        long newID = dbHandler.RegisterUser(firstname.getText().toString(), lastname.getText().toString(), email.getText().toString(), phone.getText().toString(), password.getText().toString());

                        System.out.println(newID);

                        if (newID >= 1) {
                            Toast.makeText(RegisterActivity.this, "User Registered Successfully!", Toast.LENGTH_SHORT).show();
                            status = dbHandler.userLogin(email.getText().toString(), password.getText().toString());


                            // checking the login status
                            if (status) {
                                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Something went wrong. Failed to login!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                                i.putExtra("email", send);
                                startActivity(i);
                                finish();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this, "User Registration Failed!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        errorMsg.setText("* Password and confirm password is different");
                    }

                }
            }
        });
    }

    public void navigateLogin(View view) {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        if(backPressed + TIME_INTERVAL > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(RegisterActivity.this, "Press Back Again to Exit!", Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }
}