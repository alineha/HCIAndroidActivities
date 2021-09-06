package com.example.activity1ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.textInput);
    }

    public void send(View view){
        Intent i = new Intent(this, SecondaryActivity.class);
        i.putExtra("data", editText.getText().toString());
        startActivity(i);
    }
}