package com.example.activity1ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumberText;
    private EditText secondNumberText;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberText = findViewById(R.id.firstNumber);
        secondNumberText = findViewById(R.id.secondNumber);
        resultText = findViewById(R.id.resultText);
    }

    public void sum(View view){
        Integer result;

        result = textToNumber(firstNumberText)+textToNumber(secondNumberText);

        resultText.setText(result.toString());
    }

    private Integer textToNumber(EditText editText){
        String text = editText.getText().toString();
        return text.isEmpty() ? 0 : Integer.valueOf(text);
    }
}