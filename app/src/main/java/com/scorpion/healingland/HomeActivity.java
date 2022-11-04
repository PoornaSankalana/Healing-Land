package com.scorpion.healingland;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HomeFragment(), "HomeFragment").commit();

        // making the bottom navigation bar background null
        bottomNavViewer = findViewById(R.id.bottomNavView);
        bottomNavViewer.setBackground(null);

        bottomNavViewer.setOnNavigationItemSelectedListener(Lister);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener Lister = new BottomNavigationView.OnNavigationItemSelectedListener() {
        String Fragment;
        @SuppressLint("SetTextI18n")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.home:
//                    header.setText("Welcome...");
//                    username.setText("Hello " + UserName);
                    selectedFragment = new HomeFragment();
                    Fragment = "HomeFragment";
                    break;

//                case R.id.offer:
//                    header.setText("Offers");
//                    username.setText("Here is our offers");
//                    selectedFragment = new OffersFragment();
//                    Fragment = "offerFragment";
//                    break;
//
//                case R.id.menu:
//                    header.setText("Menu");
//                    username.setText("Select Your Category Here");
//                    selectedFragment = new MenuFragment();
//                    Fragment = "MenuFragment";
//                    break;
//
//                case R.id.more:
//                    header.setText("More");
//                    username.setText("More Options for User");
//                    selectedFragment = new MoreFragment();
//                    Fragment = "MoreFragment";
//                    break;
            }

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, selectedFragment, Fragment).commit();

            return true;
        }
    };

};

