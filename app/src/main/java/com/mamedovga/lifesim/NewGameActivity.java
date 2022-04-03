package com.mamedovga.lifesim;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.mamedovga.lifesim.databinding.ActivityNewGameBinding;
import com.mamedovga.lifesim.utils.CountryUtils;
import com.mamedovga.lifesim.utils.PersonUtils;
import com.mamedovga.lifesim.utils.StringUtils;

import java.util.Locale;

public class NewGameActivity extends AppCompatActivity {

    private String gender = "male";
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

        binding.randomizeFirstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.inputFirstNameFieldEditText.setText(PersonUtils.getRandomFirstName(gender, country));
            }
        });

        binding.randomizeLastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.inputLastNameFieldEditText.setText(PersonUtils.getRandomLastName(gender, country));
            }
        });

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
                    binding.inputLastNameFieldEditText.setError(null);
                    lastName.append(binding.inputLastNameFieldEditText.getText().toString());
                } catch (NullPointerException e) {
                    binding.inputLastNameFieldEditText.setError(getString(R.string.error_empty));
                }
                if(!(StringUtils.isStringLetterOnly(lastName.toString()))) {
                    binding.inputLastNameFieldEditText.setError(getString(R.string.error_format));
                }
                if(lastName.length() > 10) {
                    binding.inputLastNameFieldEditText.setError(getString(R.string.error_length));
                }
            }
        });

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButtonMale = binding.radioGroup.findViewById(R.id.radioButtonMale);
                if(radioButtonMale.isChecked()) gender = "male";
                else gender = "female";
            }
        });
    }

    private void createGameClicked() {
        if(binding.inputFirstNameFieldEditText.getError() == null && binding.inputLastNameFieldEditText.getError() == null) {
            Intent intent = new Intent(this, GameActivity.class);
            StringBuilder firstName = new StringBuilder();
            StringBuilder lastName = new StringBuilder();

            if(binding.inputFirstNameFieldEditText.getText().toString().equals("")) {
                firstName.append(PersonUtils.getRandomFirstName(gender, country));
            } else {
                firstName.append(binding.inputFirstNameFieldEditText.getText().toString());
            }

            if(binding.inputLastNameFieldEditText.getText().toString().equals("")) {
                lastName.append(PersonUtils.getRandomLastName(gender, country));
            } else {
                lastName.append(binding.inputLastNameFieldEditText.getText().toString());
            }

            String name = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
            String surname = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

            intent.putExtra("firstName", name);
            intent.putExtra("lastName", surname);
            intent.putExtra("gender", gender);
            intent.putExtra("country", country);

            startActivity(intent);
            finish();
        }
    }
}