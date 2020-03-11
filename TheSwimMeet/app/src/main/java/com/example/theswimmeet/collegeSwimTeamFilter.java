package com.example.theswimmeet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class collegeSwimTeamFilter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_swim_team_filter);

        //https://www.ncsasports.org/womens-swimming/division-2-colleges (women Division II)

    }

    public void buttonFemaleDOneOnClick(View V) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.ncsasports.org/womens-swimming/division-1-colleges"));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }

    public void buttonFemaleDTwoOnClick(View V) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.ncsasports.org/womens-swimming/division-2-colleges"));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);

        }
    }

    public void buttonFemaleDThreeOnClick(View V) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.ncsasports.org/womens-swimming/division-3-colleges"));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
}