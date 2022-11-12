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

public class HomeFragment extends Fragment {
    Button Diseases;
    Button Tips;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);

        Diseases = view.findViewById(R.id.diseases);
        Tips = view.findViewById(R.id.tips);

        Diseases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiseasesHome diseasesHome = new DiseasesHome();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, diseasesHome);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        Tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TipsList tipsList = new TipsList();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, tipsList);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}