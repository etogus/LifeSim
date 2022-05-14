package com.mamedovga.lifesim;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.mamedovga.lifesim.databinding.FragmentStatusBinding;
import com.mamedovga.lifesim.models.BasicEvent;
import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.utils.CountryUtils;
import com.mamedovga.lifesim.utils.EventUtils;
import com.mamedovga.lifesim.utils.ImageUtils;
import com.mamedovga.lifesim.utils.ProgressBarUtils;

public class StatusFragment extends Fragment {

    private FragmentStatusBinding binding;
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
        binding.activityDisplay.setText(mainCharacterViewModel.getActivityLogText().getValue());
        binding.countryFlag.setImageResource(CountryUtils.getCountryFlag(mainCharacterViewModel.getCountry().getValue()));
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
            binding.playerAvatar.setImageBitmap(ImageUtils.decodeSampledBitmapFromResource(getResources(), mainCharacterViewModel.getAvatar().getValue()[0], 100, 100));
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
            binding.playerAvatar.setImageBitmap(ImageUtils.decodeSampledBitmapFromResource(getResources(), mainCharacterViewModel.getAvatar().getValue()[1], 100, 100));
            if(mainCharacterViewModel.getGender().getValue().equals("male"))
                binding.playerStatusImage.setImageResource(R.drawable.outline_boy_24);
            else binding.playerStatusImage.setImageResource(R.drawable.outline_girl_24);
        } else if(mainCharacterViewModel.getAge().getValue() == 7) {
            binding.playerAvatar.setImageBitmap(ImageUtils.decodeSampledBitmapFromResource(getResources(), mainCharacterViewModel.getAvatar().getValue()[2], 100, 100));
            if(mainCharacterViewModel.getGender().getValue().equals("male")) {
                binding.playerStatus.setText("Школьник");
            } else {
                binding.playerStatus.setText("Школьница");
            }
        } else if(mainCharacterViewModel.getAge().getValue() == 18) {
            binding.playerAvatar.setImageBitmap(ImageUtils.decodeSampledBitmapFromResource(getResources(), mainCharacterViewModel.getAvatar().getValue()[3], 100, 100));
            if(mainCharacterViewModel.getGender().getValue().equals("male")) {
                binding.playerStatus.setText("Студент");
            } else {
                binding.playerStatus.setText("Студентка");
            }
        } else if(mainCharacterViewModel.getAge().getValue() == 23) {
            binding.playerAvatar.setImageBitmap(ImageUtils.decodeSampledBitmapFromResource(getResources(), mainCharacterViewModel.getAvatar().getValue()[4], 100, 100));
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
        ProgressBarUtils.updateEnergyBar(mainCharacterViewModel, 100 - mainCharacterViewModel.getAge().getValue(), binding.energyBar);
        checkAge();
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        String s = "Возраст: " + mainCharacterViewModel.getAge().getValue();
        stringBuilder.append(mainCharacterViewModel.getActivityLogText().getValue()).append("\n \n");
        stringBuilder.append(s);
        stringBuilder.setSpan(new StyleSpan(Typeface.BOLD), stringBuilder.toString().indexOf(s), stringBuilder.toString().indexOf(s)+s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuilder.setSpan(new ForegroundColorSpan(Color.BLUE), stringBuilder.toString().indexOf(s), stringBuilder.toString().indexOf(s)+s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuilder.setSpan(new UnderlineSpan(), stringBuilder.toString().indexOf(s), stringBuilder.toString().indexOf(s)+s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        try {
            BasicEvent basicEvent = EventUtils.generateEvent(mainCharacterViewModel);

            EventDialogFragment dialog = EventDialogFragment.newInstance(basicEvent.getName(), basicEvent.getImage(), basicEvent.getDescription(),
                    basicEvent.getActions().get(0), basicEvent.getActions().get(1), basicEvent.getActions().get(2), basicEvent.getLabel());

            dialog.setTargetFragment(StatusFragment.this, 1);
            dialog.show(getActivity().getSupportFragmentManager(), "eventDialogFragment");
        } catch (NullPointerException e) {

        }

        mainCharacterViewModel.setActivityLogText(stringBuilder);
        binding.activityDisplay.setText(mainCharacterViewModel.getActivityLogText().getValue());
        binding.activityLog.post(new Runnable() {
            @Override
            public void run() {
                binding.activityLog.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}