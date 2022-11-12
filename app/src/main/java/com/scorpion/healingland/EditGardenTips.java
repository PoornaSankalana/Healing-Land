package com.scorpion.healingland;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import com.scorpion.healingland.Database.DBHandler;

public class EditGardenTips extends AppCompatActivity {

    Button update;
    EditText plantCode,plantName,botanicalName,plantType,water,plantingTip,fertilizingTip,imageUrl;
    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_garden_tips);

        plantName = findViewById(R.id.pName);
        botanicalName = findViewById(R.id.bName);
        plantType = findViewById(R.id.pType);
        water = findViewById(R.id.wtr);
        plantingTip = findViewById(R.id.plTip);
        fertilizingTip = findViewById(R.id.fert);
        imageUrl = findViewById(R.id.upPhoto);
        update = findViewById(R.id.updateButton);

        DBHandler dbHandler = new DBHandler(getApplicationContext());
        update.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {



String plantCodeU= plantCode.getText().toString();
                String plantNameU = plantName.getText().toString();
                String botanicalNameU = botanicalName.getText().toString();
                String plantTypeU = plantType.getText().toString();
                String waterU = water.getText().toString();
                String plantingTipU = plantingTip.getText().toString();
                String fertilizingTipU = fertilizingTip.getText().toString();
                String imageUrlU = imageUrl.getText().toString();


                Boolean status = dbHandler.EditGardenTips(plantCodeU,plantNameU,botanicalNameU,plantTypeU,waterU,plantingTipU,fertilizingTipU,imageUrlU);

                if (status == true)
                    Toast.makeText(EditGardenTips.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditGardenTips.this, "Updated Failed", Toast.LENGTH_SHORT).show();

            }
        });


    }
}