package com.example.theswimmeet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// maybe use SQLiteSwimMeetTwo for this one. Instead of save button it should always be just an update button...

public class editAccount extends AppCompatActivity implements View.OnClickListener {

    DbHelper db;

    EditText editUsername, editTeamText, editBestStrokeText, editTeasyd;
    Button buttonInsert, buttonViewProfile, buttonDelete, buttonUpdate;


    String id;
    String username;
    String team;
    String stroke;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        editTeasyd = findViewById(R.id.edit_id);
        editUsername = findViewById(R.id.edit_username);
        editTeamText = findViewById(R.id.edit_team);
        editBestStrokeText = findViewById(R.id.edit_stroke);

        buttonInsert = findViewById(R.id.button_insert);
        buttonViewProfile = findViewById(R.id.button_view_profile);
        buttonDelete = findViewById(R.id.button_delete);
        buttonUpdate = findViewById(R.id.button_update);


        buttonInsert.setOnClickListener(this);
        buttonViewProfile.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);



        db = new DbHelper(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.button_insert:
                username = editUsername.getText().toString();
                team = editTeamText.getText().toString();
                stroke = editBestStrokeText.getText().toString();
                if (username.equals("") | team.equals("") | stroke.equals("")) {
                    Toast.makeText(this, "Please fill the Fields", Toast.LENGTH_SHORT).show();
                } else {
                    db.insertStudent(username, team, stroke);
                    editTeasyd.setText("");
                    editUsername.setText("");
                    editTeamText.setText("");
                    editBestStrokeText.setText("");
                    Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button_view_profile:
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
                    editUsername.setText("");
                    editTeamText.setText("");
                    editBestStrokeText.setText("");
                    Toast.makeText(this, "deleted successfully", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button_update:
                id = editTeasyd.getText().toString().trim();
                username = editUsername.getText().toString();
                team = editTeamText.getText().toString();
                stroke = editBestStrokeText.getText().toString();
                if (id.equals("") | username.equals("") | team.equals("") | stroke.equals("")) {
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    long l = Long.parseLong(id);
                    db.updateStudent(l, username, team, stroke);
                    editTeasyd.setText("");
                    editUsername.setText("");
                    editTeamText.setText("");
                    editBestStrokeText.setText("");
                    Toast.makeText(this, "updated successfully", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}

