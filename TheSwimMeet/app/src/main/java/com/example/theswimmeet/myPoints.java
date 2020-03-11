package com.example.theswimmeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class myPoints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_points);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        // Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.myPoints);

        // perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.myGoals:
                        startActivity(new Intent(getApplicationContext(), myGoals.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.timeStandards:
                        startActivity(new Intent(getApplicationContext(), timeStandards.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.myProfile:
                        startActivity(new Intent(getApplicationContext(), myProfile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.news:
                        startActivity(new Intent(getApplicationContext(),news.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }
}


