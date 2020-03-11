package com.example.theswimmeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.emailText);
        password = findViewById(R.id.passwordText);
        login = findViewById(R.id.loginButton);
        register = findViewById(R.id.registerButton1);

    }
    public void buttonCreateOnClick(View V) {
        Intent i = new Intent(getApplicationContext(), createAccount.class);
        startActivity(i);
    }


    public void buttonLoginOnClick (View V){
        Intent i= new Intent (getApplicationContext(), myProfile.class);
        startActivity(i);
    }
}



