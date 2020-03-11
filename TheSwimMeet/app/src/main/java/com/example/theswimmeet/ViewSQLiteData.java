package com.example.theswimmeet;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewSQLiteData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sqlite_data);

        TextView textView = findViewById(R.id.view_data);
        //TextView textView = findViewById(R.id.event);

        DbHelper db = new DbHelper(this);

        String data = db.getData();
        textView.setText(data);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
