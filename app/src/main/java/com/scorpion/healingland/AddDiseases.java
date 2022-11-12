package com.scorpion.healingland;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.scorpion.healingland.Database.DBHandler;

public class AddDiseases extends Fragment {

    TextInputEditText name, desc, cause, prevention;
    TextView error;
    Button add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_add_diseases, container, false);

        name = view.findViewById(R.id.diseaseName);
        desc = view.findViewById(R.id.diseaseDescription);
        cause = view.findViewById(R.id.diseaseCause);
        prevention = view.findViewById(R.id.prevention);
        error = view.findViewById(R.id.dError);
        add = view.findViewById(R.id.addDisease);

        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty() || desc.getText().toString().isEmpty() || cause.getText().toString().isEmpty() || prevention.getText().toString().isEmpty()) {
                    error.setText("* All the fields are required");
                } else {
                    DBHandler dbHandler = new DBHandler(getActivity());
                    long id = dbHandler.AddDisease(name.getText().toString(), desc.getText().toString(), cause.getText().toString(), prevention.getText().toString());

                    if(id >= 1){
                        Toast.makeText(getActivity(), "Disease Added Successfully!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Disease Adding Failed!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        return view;
    }
}