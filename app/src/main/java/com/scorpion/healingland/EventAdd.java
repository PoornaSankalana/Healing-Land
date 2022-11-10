package com.scorpion.healingland;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.scorpion.healingland.Database.DBHandler;

public class EventAdd extends AppCompatActivity {

    TextView errorMsg;
    TextInputEditText eventname, eventdescription, date, time, venue, cname, cnumber, imgurl;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_add);

        errorMsg = findViewById(R.id.erMsg);
        eventname = findViewById(R.id.eventName);
        eventdescription = findViewById(R.id.eventDescription);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        venue = findViewById(R.id.venue);
        cname = findViewById(R.id.coordinatorName);
        cnumber = findViewById(R.id.coordinatorNumber);
        imgurl = findViewById(R.id.event_photo);
        submit = findViewById(R.id.submitbtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (eventname.getText().toString().isEmpty() || eventdescription.getText().toString().isEmpty() || date.getText().toString().isEmpty() || time.getText().toString().isEmpty() || venue.getText().toString().isEmpty() || cname.getText().toString().isEmpty() || cnumber.getText().toString().isEmpty() || imgurl.getText().toString().isEmpty()) {
                    errorMsg.setText("* All the fields are required");
                } else {

                    DBHandler dbHandler = new DBHandler(getApplicationContext());
                    long newID = dbHandler.Event(eventname.getText().toString(), eventdescription.getText().toString(), date.getText().toString(), time.getText().toString(), venue.getText().toString(), cname.getText().toString(), cnumber.getText().toString(), imgurl.getText().toString());

                    System.out.println(newID);

                    if (newID >= 1) {
                        Toast.makeText(EventAdd.this, "Event Added Successfully!", Toast.LENGTH_SHORT).show();


                        // checking the login status

                    } else {
                        errorMsg.setText("* Event added faild.");
                    }

                }
            }

        });
    }

//    public void navigateLogin(View view) {
//        Intent i = new Intent(getApplicationContext(), Events.class);
//        startActivity(i);
//        finish();
//    }
}