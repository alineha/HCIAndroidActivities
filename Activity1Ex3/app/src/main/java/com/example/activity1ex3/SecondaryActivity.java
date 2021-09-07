package com.example.activity1ex3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondaryActivity extends Activity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        textView = findViewById(R.id.textView);
    }
}
