package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    private Button button;
    private TextView sharedData;
    private final String data = String.valueOf(R.string.input);
    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedData = findViewById(R.id.TitletextView);
        myPreferenceRef = getPreferences(MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        button = findViewById(R.id. ActivitybuttonStarter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeActivity();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume-c22fokol", "Main activity active");
        String defaultValue = "Share.";
        SharedPreferences sharedPref = getSharedPreferences(data, MODE_PRIVATE);
        sharedData.setText(sharedPref.getString(data, defaultValue));
    }

    public void ChangeActivity() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

}

