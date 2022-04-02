package com.mamedovga.lifesim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.mamedovga.lifesim.databinding.ActivityNewGameBinding;
import com.mamedovga.lifesim.utils.CountryUtils;

public class NewGameActivity extends AppCompatActivity {

    private String country;
    private ActivityNewGameBinding binding;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewGameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String[] countries = CountryUtils.getCountries();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.dropdown_item, countries);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCountryTextView.setAdapter(arrayAdapter);

        binding.startGameButton.setOnClickListener(unused -> createGameClicked());
        binding.spinnerCountryTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                country = adapterView.getItemAtPosition(i).toString();
            }
        });
    }

    private void createGameClicked() {
        Intent intent = new Intent(this, GameActivity.class);

        String name = binding.inputFirstNameFieldEditText.getText().toString();
        String lastName = binding.inputLastNameFieldEditText.getText().toString();
        String gender;
        if(binding.radioGroup.getCheckedRadioButtonId() == 0) {
            gender = "male";
        } else gender = "female";

        intent.putExtra("firstName", name);
        intent.putExtra("lastName", lastName);
        intent.putExtra("gender", gender);
        intent.putExtra("country", country);

        startActivity(intent);
        finish();
    }
}