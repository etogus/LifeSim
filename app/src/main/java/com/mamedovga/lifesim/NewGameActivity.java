package com.mamedovga.lifesim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.mamedovga.lifesim.databinding.ActivityNewGameNewBinding;
import com.mamedovga.lifesim.models.Country;
import com.mamedovga.lifesim.utils.CountryUtils;

public class NewGameActivity extends AppCompatActivity {

    private String country;
    private ActivityNewGameNewBinding binding;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewGameNewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Country[] countries = CountryUtils.getCountries();
        ArrayAdapter<Country> arrayAdapter = new ArrayAdapter(this, R.layout.dropdown_item, countries);
        binding.spinnerCountryTextView.setAdapter(arrayAdapter);

        binding.startGameButton.setOnClickListener(unused -> createGameClicked());
        binding.spinnerCountryTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                country =  adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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