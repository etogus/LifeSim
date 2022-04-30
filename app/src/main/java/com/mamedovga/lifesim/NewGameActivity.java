package com.mamedovga.lifesim;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mamedovga.lifesim.databinding.ActivityNewGameBinding;

public class NewGameActivity extends AppCompatActivity {

    private ActivityNewGameBinding binding;
    private final NewGameInputFragment newGameInputFragment = new NewGameInputFragment();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewGameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportFragmentManager().beginTransaction().add(R.id.newGameContainer, newGameInputFragment, "1").commit();
    }
}