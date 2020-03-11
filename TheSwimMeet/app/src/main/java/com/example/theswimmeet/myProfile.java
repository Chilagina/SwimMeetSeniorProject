package com.example.theswimmeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class myProfile extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setSelectedItemId(R.id.myProfile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()

    {

        @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){
        switch (menuItem.getItemId()) {
            case R.id.myGoals:
                startActivity(new Intent(getApplicationContext(), myGoals.class));
                overridePendingTransition(0, 0);
                return true;
            case R.id.timeStandards:
                startActivity(new Intent(getApplicationContext(), timeStandards.class));
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


    public void buttonEditOnClick(View V) {
        Intent i = new Intent(getApplicationContext(), createAccount.class);
        startActivity(i);
    }
}







