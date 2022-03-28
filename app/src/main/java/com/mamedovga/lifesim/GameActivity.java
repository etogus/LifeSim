package com.mamedovga.lifesim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mamedovga.lifesim.databinding.ActivityGameNewBinding;
import com.mamedovga.lifesim.models.Person;
import com.mamedovga.lifesim.utils.CountryUtils;
import com.mamedovga.lifesim.utils.EventUtils;
import com.mamedovga.lifesim.utils.OtherUtils;
import com.mamedovga.lifesim.utils.PersonUtils;
import com.mamedovga.lifesim.utils.ProgressBarUtils;

public class GameActivity extends AppCompatActivity {

    private final StringBuilder activityLogText = new StringBuilder();
    private Person mainChar;
    private ActivityGameNewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameNewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();

        String playerName = intent.getStringExtra("firstName");
        String playerLastName = intent.getStringExtra("lastName");
        String playerGender = intent.getStringExtra("gender");
        String playerCountry = intent.getStringExtra("country");
        int playerAge = intent.getIntExtra("age", 0);
        int playerMood = intent.getIntExtra("mood", 0);
        int playerHealth = intent.getIntExtra("health", 0);
        int playerIntelligence = intent.getIntExtra("intelligence", 0);
        int playerLooks = intent.getIntExtra("looks", 0);
        int playerEnergy = intent.getIntExtra("energy", 0);
        int playerKarma = intent.getIntExtra("karma", 0);

        final boolean[] activityCheck = {false};

        mainChar = new Person(playerName, playerLastName, playerGender, playerCountry, playerAge, playerEnergy);
        mainChar.setPersonStats(playerMood, playerHealth, playerIntelligence, playerLooks, playerEnergy);
        mainChar.setKarma(playerKarma);

        binding.playerName.setText(mainChar.getFullName());
        binding.countryFlag.setImageResource(CountryUtils.getCountryFlag(playerCountry));

        if(mainChar.getAge() == 0) {
            PersonUtils.randomizeStats(mainChar);
            binding.playerStatus.setText("Новорожденный");
            binding.playerStatModifiers.setText("Модификаторы отсутствуют");
        }

        binding.moodBar.setProgressPercentage(mainChar.getMood(), true);
        binding.healthBar.setProgressPercentage(mainChar.getHealth(), true);
        binding.smartsBar.setProgressPercentage(mainChar.getIntelligence(), true);
        binding.looksBar.setProgressPercentage(mainChar.getLooks(), true);
        binding.energyBar.setProgressPercentage(mainChar.getEnergy(), true);

        binding.statusActions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        binding.assetsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        binding.relationshipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        binding.actionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!activityCheck[0]) {
                    int n = OtherUtils.getRandomNumber(1, 4);
                    if(n == 1) {
                        ProgressBarUtils.updateMoodBar(mainChar, 1, binding.moodBar);
                        activityLogText.append("Я посмотрел интересный фильм. \n \n");
                        binding.activityDisplay.setText(activityLogText);
                        binding.activityLog.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.activityLog.fullScroll(View.FOCUS_DOWN);
                            }
                        });
                    }
                    else if(n == 2) {
                        ProgressBarUtils.updateHealthBar(mainChar, 1, binding.healthBar);
                        ProgressBarUtils.updateMoodBar(mainChar, 1, binding.moodBar);
                        activityLogText.append("Я сходил на пробежку. Чувствую себя сильнее. \n \n");
                        binding.activityDisplay.setText(activityLogText);
                        binding.activityLog.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.activityLog.fullScroll(View.FOCUS_DOWN);
                            }
                        });
                    }
                    else if(n == 3) {
                        ProgressBarUtils.updateIntellectBar(mainChar, 2, binding.smartsBar);
                        ProgressBarUtils.updateMoodBar(mainChar, 2, binding.moodBar);
                        activityLogText.append("Я прочитал захватывающую книгу. \n \n");
                        binding.activityDisplay.setText(activityLogText);
                        binding.activityLog.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.activityLog.fullScroll(View.FOCUS_DOWN);
                            }
                        });
                    }
                    else if(n == 4) {
                        ProgressBarUtils.updateLooksBar(mainChar, 2, binding.looksBar);
                        ProgressBarUtils.updateMoodBar(mainChar, 1, binding.moodBar);
                        activityLogText.append("Я позанимался в спортзале. \n \n");
                        binding.activityDisplay.setText(activityLogText);
                        binding.activityLog.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.activityLog.fullScroll(View.FOCUS_DOWN);
                            }
                        });
                    }
                    activityCheck[0] = true;
                }
            }
        });


        binding.nextYearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainChar.setAge(mainChar.getAge() + 1);
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
                //EventUtils.generateEvent(mainChar);
                activityCheck[0] = false;
            }
        });
    }

    public void checkAge() {
        if (mainChar.getAge() == 120) {
            Intent endIntent = new Intent(this, EndGameActivity.class);
            startActivity(endIntent);
            finish();
        } else if(mainChar.getAge() == 2) {
            binding.playerStatus.setText("Дитя");
        } else if(mainChar.getAge() == 4) {
            binding.playerStatus.setText("Ребёнок");
        } else if(mainChar.getAge() == 7) {
            binding.playerStatus.setText("Школьник");
        } else if(mainChar.getAge() == 18) {
            binding.playerStatus.setText("Студент");
        } else if(mainChar.getAge() == 23) {
            binding.playerStatus.setText("Молодой человек");
        }
    }
}