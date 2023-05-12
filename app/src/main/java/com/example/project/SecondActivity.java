package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private final String data1 = String.valueOf(R.string.input);
    private Button button;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        sharedPreferences = getSharedPreferences(data1, MODE_PRIVATE);

        button = findViewById(R.id.secondButtonsave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retainData();
                finish();


            }
        });
    }


    private void retainData() {
        EditText userInputEditText = findViewById(R.id.input);
        String userInputData = userInputEditText.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(data1, userInputData);
        String key = "sharedPreferences";

        editor.apply();
    }

}

