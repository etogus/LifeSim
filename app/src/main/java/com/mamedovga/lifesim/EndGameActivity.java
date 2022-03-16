package com.mamedovga.lifesim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class EndGameActivity extends AppCompatActivity {

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent = getIntent();

        Button playAgain = findViewById(R.id.startNewGame);
        playAgain.setOnClickListener(unused -> launchNewGameActivity());
    }

    public void launchNewGameActivity() {
        Intent intent = new Intent(this, NewGameActivity.class);
        startActivity(intent);
    }
}