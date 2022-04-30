package com.mamedovga.lifesim;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.mamedovga.lifesim.databinding.FragmentNewGameInputBinding;
import com.mamedovga.lifesim.utils.CountryUtils;
import com.mamedovga.lifesim.utils.ImageUtils;
import com.mamedovga.lifesim.utils.NumberUtils;
import com.mamedovga.lifesim.utils.PersonUtils;
import com.mamedovga.lifesim.utils.StringUtils;

public class NewGameInputFragment extends Fragment {

    private FragmentNewGameInputBinding binding;
    private static String gender = "male";
    private String country = "Россия";
    private int[] avatar;
    private final NewGameAvatarFragment newGameAvatarFragment = new NewGameAvatarFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                int[] result = bundle.getIntArray("avatar");
                binding.chooseAvatar.setImageBitmap(
                        ImageUtils.decodeSampledBitmapFromResource(getResources(), result[4], 100, 100));
                avatar = result;
            }
        });

        binding = FragmentNewGameInputBinding.inflate(inflater, container, false);

        String[] countries = CountryUtils.getCountries();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item, countries);
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
                if(firstName.length() > 12) {
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
                if(lastName.length() > 12) {
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

        binding.chooseAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(((ViewGroup)getView().getParent()).getId(), newGameAvatarFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void createGameClicked() {
        if(binding.inputFirstNameFieldEditText.getError() == null && binding.inputLastNameFieldEditText.getError() == null) {
            Intent intent = new Intent(getActivity(), GameActivity.class);
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

            if(avatar == null) {
                if(gender.equals("male")) {
                    avatar = PersonUtils.maleAvatars[NumberUtils.getRandomNumber(0, PersonUtils.maleAvatars.length - 1)];
                    Toast.makeText(getContext(), "Вы выбрали мужской пол. Выбрана случайная мужская внешность.", Toast.LENGTH_LONG).show();
                }
                else {
                    avatar = PersonUtils.femaleAvatars[NumberUtils.getRandomNumber(0, PersonUtils.femaleAvatars.length - 1)];
                    Toast.makeText(getContext(), "Вы выбрали женский пол. Выбрана случайная женская внешность.", Toast.LENGTH_LONG).show();
                }
            } else if(NumberUtils.contains(PersonUtils.maleAvatars, avatar)) {
                if (!gender.equals("male")) {
                    avatar = PersonUtils.femaleAvatars[NumberUtils.getRandomNumber(0, PersonUtils.femaleAvatars.length - 1)];
                    Toast.makeText(getContext(), "Вы выбрали женский пол. Выбрана случайная женская внешность.", Toast.LENGTH_LONG).show();
                }
            } else if(NumberUtils.contains(PersonUtils.femaleAvatars, avatar)) {
                if(gender.equals("male")) {
                    avatar = PersonUtils.maleAvatars[NumberUtils.getRandomNumber(0, PersonUtils.maleAvatars.length - 1)];
                    Toast.makeText(getContext(), "Вы выбрали мужской пол. Выбрана случайная мужская внешность.", Toast.LENGTH_LONG).show();
                }
            }
            intent.putExtra("avatar", avatar);

            startActivity(intent);
            requireActivity().finish();
        }
    }

    public static String getGender() {
        return gender;
    }
}