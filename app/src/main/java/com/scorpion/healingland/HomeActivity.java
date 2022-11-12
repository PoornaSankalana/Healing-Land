package com.scorpion.healingland;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavViewer;


    String thisFragment;

    // back button
    private static final int TIME_INTERVAL = 2000;
    private long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new HomeFragment(), "HomeFragment").commit();

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
            switch (item.getItemId()) {
                case R.id.home:
//                    header.setText("Welcome...");
//                    username.setText("Hello " + UserName);
                    selectedFragment = new HomeFragment();
                    Fragment = "HomeFragment";
                    thisFragment = Fragment;
                    break;

                case R.id.tips:
//                    header.setText("Offers");
//                    username.setText("Here is our offers");
                    selectedFragment = new TipsList();
                    Fragment = "offerFragment";
                    break;
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

//    @Override
//    public void onBackPressed() {
//        if (backPressed + TIME_INTERVAL > System.currentTimeMillis() && thisFragment.equals("HomeFragment")) {
//            super.onBackPressed();
//            return;
//        } else {
//            Toast.makeText(HomeActivity.this, "Press Back Again to Exit!", Toast.LENGTH_SHORT).show();
//        }
//        backPressed = System.currentTimeMillis();
//    }

};

