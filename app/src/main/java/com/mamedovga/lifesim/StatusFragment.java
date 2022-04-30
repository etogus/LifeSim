package com.mamedovga.lifesim;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
import com.mamedovga.lifesim.utils.ImageUtils;

public class StatusFragment extends Fragment {

    private FragmentStatusBinding binding;
    //private Person mainChar = new Person();
    private final StringBuilder activityLogText = new StringBuilder();
    private MainCharacterViewModel mainCharacterViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStatusBinding.inflate(inflater, container, false);
        Log.e("onCreateView", "Age = " + mainCharacterViewModel.getAge().getValue());
        binding.playerName.setText(mainCharacterViewModel.getName().getValue() + " " + mainCharacterViewModel.getLastName().getValue());
        binding.moodBar.setProgressPercentage(mainCharacterViewModel.getMood().getValue(), true);
        binding.healthBar.setProgressPercentage(mainCharacterViewModel.getHealth().getValue(), true);
        binding.smartsBar.setProgressPercentage(mainCharacterViewModel.getIntelligence().getValue(), true);
        binding.looksBar.setProgressPercentage(mainCharacterViewModel.getLooks().getValue(), true);
        binding.energyBar.setProgressPercentage(mainCharacterViewModel.getEnergy().getValue(), true);
        binding.playerAvatar.setImageBitmap(ImageUtils.decodeSampledBitmapFromResource(getResources(), mainCharacterViewModel.getAvatar().getValue(), 100, 100));
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainCharacterViewModel = new ViewModelProvider(requireActivity()).get(MainCharacterViewModel.class);

//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getName().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                binding.playerName.setText(s);
//                mainChar.setName(s);
//            }
//        });
//
//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getLastName().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                mainChar.setLastName(s);
//                binding.playerName.setText(mainChar.getFullName());
//            }
//        });
//
//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getGender().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                mainChar.setGender(s);
//            }
//        });
//
//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getCountry().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                mainChar.setCountry(s);
//                binding.countryFlag.setImageResource(CountryUtils.getCountryFlag(s));
//            }
//        });
//
//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getAge().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer i) {
//                mainChar.setAge(i);
//                Log.e("onChanged", "Age = " + mainCharacterViewModel.getAge().getValue());
//            }
//        });
//
//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getMood().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer i) {
//                mainChar.setMood(i);
//                binding.moodBar.setProgressPercentage(i, true);
//            }
//        });
//
//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getHealth().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer i) {
//                mainChar.setHealth(i);
//                binding.healthBar.setProgressPercentage(i, true);
//            }
//        });
//
//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getIntelligence().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer i) {
//                mainChar.setIntelligence(i);
//                binding.smartsBar.setProgressPercentage(i, true);
//            }
//        });
//
//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getLooks().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer i) {
//                mainChar.setLooks(i);
//                binding.looksBar.setProgressPercentage(i, true);
//            }
//        });
//
//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getEnergy().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer i) {
//                mainChar.setEnergy(i);
//                binding.energyBar.setProgressPercentage(i, true);
//            }
//        });
//
//        ViewModelProviders.of(getActivity()).get(MainCharacterViewModel.class).getKarma().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer i) {
//                mainChar.setKarma(i);
//            }
//        });
    }

    public boolean isEndGame() {
        return (mainCharacterViewModel.getAge().getValue() == 120);
    }

    public void checkAge() {
        if(mainCharacterViewModel.getAge().getValue() == 1) {
            binding.playerStatus.setText("Новорожденный");
            binding.playerStatModifiers.setText("Модификаторы отсутствуют");
        } else if(mainCharacterViewModel.getAge().getValue() == 2) {
            binding.playerStatus.setText("Дитя");
            binding.playerStatusImage.setImageResource(R.drawable.ic_baseline_child_36);
        } else if(mainCharacterViewModel.getAge().getValue() == 4) {
            binding.playerStatus.setText("Ребёнок");
            if(mainCharacterViewModel.getGender().getValue().equals("male"))
                binding.playerStatusImage.setImageResource(R.drawable.outline_boy_24);
            else binding.playerStatusImage.setImageResource(R.drawable.outline_girl_24);
        } else if(mainCharacterViewModel.getAge().getValue() == 7) {
            binding.playerStatus.setText("Школьник");
        } else if(mainCharacterViewModel.getAge().getValue() == 18) {
            binding.playerStatus.setText("Студент");
        } else if(mainCharacterViewModel.getAge().getValue() == 23) {
            binding.playerStatus.setText("Молодой человек");
            if(mainCharacterViewModel.getGender().getValue().equals("male"))
                binding.playerStatusImage.setImageResource(R.drawable.outline_man_24);
            else binding.playerStatusImage.setImageResource(R.drawable.outline_woman_24);
        }
    }

    public void nextYear() {
        Log.e("onChanged", "Age = " + mainCharacterViewModel.getAge().getValue());
        //mainChar.setAge(mainChar.getAge() + 1);
        mainCharacterViewModel.setAge(mainCharacterViewModel.getAge().getValue() + 1);
        checkAge();
        String randomEvent = EventUtils.generateEvent(mainCharacterViewModel);
        activityLogText.append("Возраст: ").append(mainCharacterViewModel.getAge().getValue());
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