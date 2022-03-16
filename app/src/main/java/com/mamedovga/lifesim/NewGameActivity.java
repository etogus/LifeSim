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

import com.mamedovga.lifesim.models.Country;
import com.mamedovga.lifesim.utils.CountryUtils;

public class NewGameActivity extends AppCompatActivity {

    private TextView errorMessage;
    private String gender;
    private String country;
    private Spinner spinnerCountry;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        errorMessage = findViewById(R.id.errorMessage);
        errorMessage.setVisibility(View.GONE);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                boolean isChecked = checkedRadioButton.isChecked();
                if (isChecked) {
                    gender = (String) checkedRadioButton.getText();
                }
            }
        });

        Country[] countries = CountryUtils.getCountries();
        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);

        ArrayAdapter<String> countryAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(countryAdapter);
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                country =  adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button startGame = findViewById(R.id.startGame);
        startGame.setOnClickListener(unused -> createGameClicked());
    }

    private void createGameClicked() {
        Intent intent = new Intent(this, GameActivity.class);

        EditText enterName = findViewById(R.id.enterName);
        String name = enterName.getText().toString();

        EditText enterLastName = findViewById(R.id.enterLastName);
        String lastName = enterLastName.getText().toString();

        if (name.trim().isEmpty() || lastName.trim().isEmpty()) {
            errorMessage.setText("Поле имени или фамилии не заполнено!");
            errorMessage.setTextColor(Color.RED);
            errorMessage.setVisibility(View.VISIBLE);
        } else {
            intent.putExtra("name", name);
            intent.putExtra("lastName", lastName);
            intent.putExtra("gender", gender);
            intent.putExtra("country", country);

            startActivity(intent);
            finish();
        }
    }
}