package com.mamedovga.lifesim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton logoButton = findViewById(R.id.logoButton);
        logoButton.setOnClickListener(unused -> launchNewGameActivity());

    }
    public void launchNewGameActivity() {
        Intent intent = new Intent(this, NewGameActivity.class);
        startActivity(intent);
    }
}