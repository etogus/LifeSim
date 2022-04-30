package com.mamedovga.lifesim;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mamedovga.lifesim.databinding.FragmentStatusBinding;
import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.utils.EventUtils;
import com.mamedovga.lifesim.utils.ImageUtils;

public class StatusFragment extends Fragment {

    private FragmentStatusBinding binding;
    private final StringBuilder activityLogText = new StringBuilder();
    private MainCharacterViewModel mainCharacterViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStatusBinding.inflate(inflater, container, false);
        binding.playerName.setText(mainCharacterViewModel.getName().getValue() + " " + mainCharacterViewModel.getLastName().getValue());
        binding.moodBar.setProgressPercentage(mainCharacterViewModel.getMood().getValue(), true);
        binding.healthBar.setProgressPercentage(mainCharacterViewModel.getHealth().getValue(), true);
        binding.smartsBar.setProgressPercentage(mainCharacterViewModel.getIntelligence().getValue(), true);
        binding.looksBar.setProgressPercentage(mainCharacterViewModel.getLooks().getValue(), true);
        binding.energyBar.setProgressPercentage(mainCharacterViewModel.getEnergy().getValue(), true);
        binding.playerAvatar.setImageBitmap(ImageUtils.decodeSampledBitmapFromResource(getResources(), mainCharacterViewModel.getAvatar().getValue(), 100, 100));
        checkAge();
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
    }

    public boolean isEndGame() {
        return (mainCharacterViewModel.getAge().getValue() == 120);
    }

    public void checkAge() {
        if(mainCharacterViewModel.getAge().getValue() == 0) {
            binding.playerStatModifiers.setText("Модификаторы отсутствуют");
            if(mainCharacterViewModel.getGender().getValue().equals("male")) {
                binding.playerStatus.setText("Новорожденный");
            } else {
                binding.playerStatus.setText("Новорожденная");
            }
        } else if(mainCharacterViewModel.getAge().getValue() == 2) {
            binding.playerStatus.setText("Дитя");
            binding.playerStatusImage.setImageResource(R.drawable.ic_baseline_child_36);
        } else if(mainCharacterViewModel.getAge().getValue() == 4) {
            binding.playerStatus.setText("Ребёнок");
            if(mainCharacterViewModel.getGender().getValue().equals("male"))
                binding.playerStatusImage.setImageResource(R.drawable.outline_boy_24);
            else binding.playerStatusImage.setImageResource(R.drawable.outline_girl_24);
        } else if(mainCharacterViewModel.getAge().getValue() == 7) {
            if(mainCharacterViewModel.getGender().getValue().equals("male")) {
                binding.playerStatus.setText("Школьник");
            } else {
                binding.playerStatus.setText("Школьница");
            }
        } else if(mainCharacterViewModel.getAge().getValue() == 18) {
            if(mainCharacterViewModel.getGender().getValue().equals("male")) {
                binding.playerStatus.setText("Студент");
            } else {
                binding.playerStatus.setText("Студентка");
            }
        } else if(mainCharacterViewModel.getAge().getValue() == 23) {
            if(mainCharacterViewModel.getGender().getValue().equals("male")) {
                binding.playerStatus.setText("Молодой человек");
                binding.playerStatusImage.setImageResource(R.drawable.outline_man_24);
            } else {
                binding.playerStatus.setText("Девушка");
                binding.playerStatusImage.setImageResource(R.drawable.outline_woman_24);
            }
        }
    }

    public void nextYear() {
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