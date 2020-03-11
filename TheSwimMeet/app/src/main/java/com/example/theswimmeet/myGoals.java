package com.example.theswimmeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class myGoals extends AppCompatActivity implements View.OnClickListener {

    DbHelper db;

    EditText editTeasyd, editTextEvent, edittextBest, editTextGoal;
    Button buttonInsert, buttonView, buttonDelete, buttonUpdate, buttonSearch;

    String id;
    String event;
    String best;
    String goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_goals);

        editTeasyd = findViewById(R.id.edit_id);
        editTextEvent = findViewById(R.id.edit_event);
        edittextBest = findViewById(R.id.edit_bestTime);
        editTextGoal = findViewById(R.id.edit_GoalTime);

        buttonInsert = findViewById(R.id.button_insert);
        buttonView = findViewById(R.id.button_view);
        buttonDelete = findViewById(R.id.button_delete);
        buttonUpdate = findViewById(R.id.button_update);
        buttonSearch = findViewById(R.id.button_search);

        buttonInsert.setOnClickListener(this);
        buttonView.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);

        db = new DbHelper(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setSelectedItemId(R.id.myGoals);

        // perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.myProfile:
                        startActivity(new Intent(getApplicationContext(), myProfile.class));
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


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_insert:
                event = editTextEvent.getText().toString();
                best = edittextBest.getText().toString();
                goal = editTextGoal.getText().toString();
                if (event.equals("") | best.equals("") | goal.equals("")) {
                    Toast.makeText(this, "Please fill the Fields", Toast.LENGTH_SHORT).show();
                } else {
                    db.insertStudent(event, best, goal);
                    editTeasyd.setText("");
                    editTextEvent.setText("");
                    edittextBest.setText("");
                    editTextGoal.setText("");
                    Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button_view:
                Intent intent = new Intent(getApplicationContext(), ViewSQLiteData.class);
                startActivity(intent);
                break;

            case R.id.button_delete:
                id = editTeasyd.getText().toString();
                if (id.equals("")) {
                    Toast.makeText(this, "Please fill the Id", Toast.LENGTH_SHORT).show();
                } else {
                    long l = Long.parseLong(id);
                    db.deleteStudent(l);
                    editTeasyd.setText("");
                    editTextEvent.setText("");
                    edittextBest.setText("");
                    editTextGoal.setText("");
                    Toast.makeText(this, "deleted successfully", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button_update:
                id = editTeasyd.getText().toString().trim();
                event = editTextEvent.getText().toString();
                best = edittextBest.getText().toString();
                goal = editTextGoal.getText().toString();
                if (id.equals("") | event.equals("") | best.equals("") | goal.equals("")) {
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    long l = Long.parseLong(id);
                    db.updateStudent(l, event, best, goal);
                    editTeasyd.setText("");
                    editTextEvent.setText("");
                    edittextBest.setText("");
                    editTextGoal.setText("");
                    Toast.makeText(this, "updated successfully", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_search:
                id = editTeasyd.getText().toString().trim();
                if (id.equals("")) {
                    Toast.makeText(this, "Please Fill the Id", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        long l1 = Long.parseLong(id);
                        event = db.getName(l1);
                        best = db.getEmail(l1);
                        goal = db.getMobile(l1);

                        editTextEvent.setText(event);
                        edittextBest.setText(best);
                        editTextGoal.setText(goal);
                        Toast.makeText(this, "searched successfully", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        Toast.makeText(this, "Id is not Available", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}



