package com.example.theswimmeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class timeStandards extends AppCompatActivity {

    Button button;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_standards);

        button = findViewById(R.id.timeStandardsButton);
        buttonTwo = findViewById(R.id.worldRecordsButton);
        buttonThree = findViewById(R.id.collegeSearchButton);
        buttonFour =findViewById(R.id.timeSearchButton);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        // Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.timeStandards);

        // perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.myGoals:
                        startActivity(new Intent(getApplicationContext(), myGoals.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.myProfile:
                        startActivity(new Intent(getApplicationContext(), myProfile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.myPoints:
                        startActivity(new Intent(getApplicationContext(), myPoints.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.news:
                        startActivity(new Intent(getApplicationContext(), news.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });
    }

    public void buttonTimeStandardsOnClick(View V) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.usaswimming.org/Home/times/time-standards"));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }

    public void buttonWorldRecordsOnClick(View V) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.usaswimming.org/Home/times/data-hub"));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }

    public void buttonTimeSearchOnClick(View V) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.usaswimming.org/Home/times/individual-times-search"));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }

    public void buttonCollegeSearchOnClick(View V) {
        Intent i = new Intent(getApplicationContext(), collegeSwimTeamFilter.class);
        startActivity(i);


    }


}






