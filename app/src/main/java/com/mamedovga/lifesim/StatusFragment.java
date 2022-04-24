package com.mamedovga.lifesim;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.mamedovga.lifesim.databinding.FragmentStatusBinding;
import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.models.Person;
import com.mamedovga.lifesim.utils.CountryUtils;
import com.mamedovga.lifesim.utils.EventUtils;

public class StatusFragment extends Fragment {

    private FragmentStatusBinding binding;
    private Person mainChar = new Person();
    private final StringBuilder activityLogText = new StringBuilder();
    private MainCharacterViewModel mainCharacterViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStatusBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainCharacterViewModel = new ViewModelProvider(requireActivity()).get(MainCharacterViewModel.class);

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.playerName.setText(s);
                mainChar.setName(s);
            }
        });

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getLastName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mainChar.setLastName(s);
                binding.playerName.setText(mainChar.getFullName());
            }
        });

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getGender().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mainChar.setGender(s);
            }
        });

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getCountry().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mainChar.setCountry(s);
                binding.countryFlag.setImageResource(CountryUtils.getCountryFlag(s));
            }
        });

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getAge().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                mainChar.setAge(i);
            }
        });

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getMood().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                mainChar.setMood(i);
                binding.moodBar.setProgressPercentage(i, true);
            }
        });

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getHealth().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                mainChar.setHealth(i);
                binding.healthBar.setProgressPercentage(i, true);
            }
        });

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getIntelligence().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                mainChar.setIntelligence(i);
                binding.smartsBar.setProgressPercentage(i, true);
            }
        });

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getLooks().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                mainChar.setLooks(i);
                binding.looksBar.setProgressPercentage(i, true);
            }
        });

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getEnergy().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                mainChar.setEnergy(i);
                binding.energyBar.setProgressPercentage(i, true);
            }
        });

        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getKarma().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                mainChar.setKarma(i);
            }
        });
    }

    public boolean isEndGame() {
        return (mainChar.getAge() == 120);
    }

    public void checkAge() {
        if(mainChar.getAge() == 0) {
            binding.playerStatus.setText("Новорожденный");
            binding.playerStatModifiers.setText("Модификаторы отсутствуют");
        } else if(mainChar.getAge() == 2) {
            binding.playerStatus.setText("Дитя");
            binding.playerStatusImage.setImageResource(R.drawable.ic_baseline_child_36);
        } else if(mainChar.getAge() == 4) {
            binding.playerStatus.setText("Ребёнок");
            if(mainChar.getGender().equals("male"))
                binding.playerStatusImage.setImageResource(R.drawable.outline_boy_24);
            else binding.playerStatusImage.setImageResource(R.drawable.outline_girl_24);
        } else if(mainChar.getAge() == 7) {
            binding.playerStatus.setText("Школьник");
        } else if(mainChar.getAge() == 18) {
            binding.playerStatus.setText("Студент");
        } else if(mainChar.getAge() == 23) {
            binding.playerStatus.setText("Молодой человек");
            if(mainChar.getGender().equals("male"))
                binding.playerStatusImage.setImageResource(R.drawable.outline_man_24);
            else binding.playerStatusImage.setImageResource(R.drawable.outline_woman_24);
        }
    }

    public void nextYear() {
        mainChar.setAge(mainChar.getAge() + 1);
        mainCharacterViewModel.setAge(mainChar.getAge());
        checkAge();
        String randomEvent = EventUtils.generateEvent(mainChar);
        activityLogText.append("Возраст: ").append(mainChar.getAge());
        binding.activityDisplay.setText(activityLogText);
        binding.activityDisplay.setTextColor(Color.BLUE);
        activityLogText.append("\n").append(randomEvent);
        binding.activityLog.post(new Runnable() {
            @Override
            public void run() {
                binding.activityLog.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}