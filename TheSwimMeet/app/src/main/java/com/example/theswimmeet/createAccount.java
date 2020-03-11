package com.example.theswimmeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class createAccount extends AppCompatActivity {

    EditText username, password, email, swimTeamName;
    Button register, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        username= findViewById(R.id.usernameRegister);
        password = findViewById(R.id.passwordRegister);
        email = findViewById(R.id.emailRegister);
        register = findViewById(R.id.registerButton);
    }

    public void buttonLoginOnClick(View V) {
        Intent i = new Intent(getApplicationContext(), myProfile.class);
        startActivity(i);
    }
}
