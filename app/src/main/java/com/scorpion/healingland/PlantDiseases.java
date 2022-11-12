package com.scorpion.healingland;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class PlantDiseases extends Fragment {
    Button bacterialSpotView;
    Button addNewDisease;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_diseases, container,false);

        bacterialSpotView = view.findViewById(R.id.bacterialSpotBtn);
        addNewDisease = view.findViewById(R.id.addDisease);

        bacterialSpotView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BacterialSpotView bacterialSpotView = new BacterialSpotView();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, bacterialSpotView);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        addNewDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddDiseases addDiseases = new AddDiseases();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, addDiseases);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}