package com.scorpion.healingland;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.scorpion.healingland.Database.DBHandler;

import android.os.Bundle;

public class AddGardenTips extends AppCompatActivity {

    TextView errorMsg;
    TextInputEditText plantCode, plantName, botanicalName, plantType, water, plantingTip, fertilizingTip, imageUrl;
    Button submit;
    boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_garden_tips);

        errorMsg = findViewById(R.id.errorText);
        plantCode = findViewById(R.id.plantCode);
        plantName = findViewById(R.id.plantName);
        botanicalName = findViewById(R.id.botanicalName);
        plantType = findViewById(R.id.plantType);
        water = findViewById(R.id.water);
        plantingTip = findViewById(R.id.plantingTip);
        fertilizingTip = findViewById(R.id.fertilizer);
        imageUrl = findViewById(R.id.uploadAPhoto);
        submit = findViewById(R.id.addTipsBtn);


        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (plantCode.getText().toString().isEmpty() || plantName.getText().toString().isEmpty() || botanicalName.getText().toString().isEmpty() || plantType.getText().toString().isEmpty() || water.getText().toString().isEmpty() || plantingTip.getText().toString().isEmpty() || fertilizingTip.getText().toString().isEmpty() || imageUrl.getText().toString().isEmpty()) {
                    errorMsg.setText("* All the fields are required");
                } else {
                        DBHandler dbHandler = new DBHandler(getApplicationContext());
                        long newID = dbHandler.AddGardenTips(plantCode.getText().toString(), plantName.getText().toString(), botanicalName.getText().toString(), plantType.getText().toString(), water.getText().toString(), plantingTip.getText().toString(), fertilizingTip.getText().toString(), imageUrl.getText().toString());

                        System.out.println(newID);

                        if (newID >= 1) {
                            Toast.makeText(AddGardenTips.this, "Garden Tip Added Successfully!", Toast.LENGTH_SHORT).show();


                            // checking the login status

                        } else {
                            Toast.makeText(AddGardenTips.this, "Adding Garden Tip is Failed!", Toast.LENGTH_SHORT).show();
                        }

                }
            }
        });

    }

//    public void navigateLogin(View view) {
//        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
//        startActivity(i);
//        finish();
//    }
}