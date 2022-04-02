package com.mamedovga.lifesim;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.mamedovga.lifesim.databinding.ActivityNewGameBinding;
import com.mamedovga.lifesim.utils.CountryUtils;
import com.mamedovga.lifesim.utils.PersonUtils;
import com.mamedovga.lifesim.utils.StringUtils;

public class NewGameActivity extends AppCompatActivity {

    private String country = "Россия";
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
        binding.spinnerCountryTextView.setText(countries[0], false);

        binding.startGameButton.setOnClickListener(unused -> createGameClicked());

        binding.spinnerCountryTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                country = adapterView.getItemAtPosition(i).toString();
            }
        });

        binding.inputFirstNameFieldEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                StringBuilder firstName = new StringBuilder();
                try {
                    binding.inputFirstNameFieldEditText.setError(null);
                    firstName.append(binding.inputFirstNameFieldEditText.getText().toString());
                } catch (NullPointerException e) {
                    binding.inputFirstNameFieldEditText.setError(getString(R.string.error_empty));
                }
                if(!(StringUtils.isStringLetterOnly(firstName.toString()))) {
                    binding.inputFirstNameFieldEditText.setError(getString(R.string.error_format));
                }
                if(firstName.length() > 10) {
                    binding.inputFirstNameFieldEditText.setError(getString(R.string.error_length));
                }
            }
        });

        binding.inputLastNameFieldEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                StringBuilder lastName = new StringBuilder();
                try {
                    binding.inputFirstNameFieldEditText.setError(null);
                    lastName.append(binding.inputFirstNameFieldEditText.getText().toString());
                } catch (NullPointerException e) {
                    binding.inputFirstNameFieldEditText.setError(getString(R.string.error_empty));
                }
                if(!(StringUtils.isStringLetterOnly(lastName.toString()))) {
                    binding.inputFirstNameFieldEditText.setError(getString(R.string.error_format));
                }
                if(lastName.length() > 10) {
                    binding.inputFirstNameFieldEditText.setError(getString(R.string.error_length));
                }
            }
        });
    }

    private void createGameClicked() {
        Intent intent = new Intent(this, GameActivity.class);
        StringBuilder firstName = new StringBuilder();
        StringBuilder lastName = new StringBuilder();

        String gender;
        if(binding.radioGroup.getCheckedRadioButtonId() == 0) {
            gender = "male";
        } else gender = "female";

        if(binding.inputFirstNameFieldEditText.getText().toString().equals("")) {
            firstName.append(PersonUtils.getRandomName(gender, country));
        }


        if(binding.inputLastNameFieldEditText.getText().toString().equals("")) {
            lastName.append(PersonUtils.getRandomName(gender, country));
        }

        intent.putExtra("firstName", firstName.toString());
        intent.putExtra("lastName", lastName.toString());
        intent.putExtra("gender", gender);
        intent.putExtra("country", country);

        startActivity(intent);
        finish();
    }
}