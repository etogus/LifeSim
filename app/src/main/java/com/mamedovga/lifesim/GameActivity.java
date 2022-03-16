package com.mamedovga.lifesim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mamedovga.lifesim.models.Person;
import com.mamedovga.lifesim.utils.EventUtils;
import com.mamedovga.lifesim.utils.OtherUtils;
import com.mamedovga.lifesim.utils.PersonUtils;
import com.mamedovga.lifesim.utils.ProgressBarUtils;

public class GameActivity extends AppCompatActivity {

    private final StringBuilder activityLogText = new StringBuilder();
    private Person mainChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();

        TextView activityDisplay = findViewById(R.id.activityDisplay);
        ScrollView scrollView = findViewById(R.id.activityLog);
        Button actions = findViewById(R.id.actions);
        Button inventory = findViewById(R.id.inventory);
        Button relationships = findViewById(R.id.relationships);
        Button activities = findViewById(R.id.activities);
        Button nextYear = findViewById(R.id.nextYear);
        ProgressBar moodBar = findViewById(R.id.moodBar);
        ProgressBar healthBar = findViewById(R.id.healthBar);
        ProgressBar intelligenceBar = findViewById(R.id.intellectBar);
        ProgressBar looksBar = findViewById(R.id.looksBar);
        final boolean[] activityCheck = {false};

        String playerName = intent.getStringExtra("name");
        String playerLastName = intent.getStringExtra("lastName");
        String playerGender = intent.getStringExtra("gender");
        String playerCountry = intent.getStringExtra("country");
        int playerAge = intent.getIntExtra("age", 0);
        int playerMood = intent.getIntExtra("mood", 0);
        int playerHealth = intent.getIntExtra("health", 0);
        int playerIntelligence = intent.getIntExtra("intelligence", 0);
        int playerLooks = intent.getIntExtra("looks", 0);
        int playerKarma = intent.getIntExtra("karma", 0);

        mainChar = new Person(playerName, playerLastName, playerGender, playerCountry, playerAge);
        mainChar.setPersonStats(playerMood, playerHealth, playerIntelligence, playerLooks);
        mainChar.setKarma(playerKarma);

        TextView mainCharName = findViewById(R.id.playerName);
        mainCharName.setText(mainChar.getFullName());

        if(mainChar.getAge() == 0)
            PersonUtils.randomizeStats(mainChar);

        moodBar.setProgress(mainChar.getMood());
        healthBar.setProgress(mainChar.getHealth());
        intelligenceBar.setProgress(mainChar.getIntelligence());
        looksBar.setProgress(mainChar.getLooks());

        actions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        relationships.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!activityCheck[0]) {
                    int n = OtherUtils.getRandomNumber(1, 4);
                    if(n == 1) {
                        ProgressBarUtils.updateMoodBar(mainChar, 1, moodBar);
                        activityLogText.append("Я посмотрел интересный фильм. \n \n");
                        activityDisplay.setText(activityLogText);
                        scrollView.post(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.fullScroll(View.FOCUS_DOWN);
                            }
                        });
                    }
                    else if(n == 2) {
                        ProgressBarUtils.updateHealthBar(mainChar, 1, healthBar);
                        ProgressBarUtils.updateMoodBar(mainChar, 1, moodBar);
                        activityLogText.append("Я сходил на пробежку. Чувствую себя сильнее. \n \n");
                        activityDisplay.setText(activityLogText);
                        scrollView.post(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.fullScroll(View.FOCUS_DOWN);
                            }
                        });
                    }
                    else if(n == 3) {
                        ProgressBarUtils.updateIntellectBar(mainChar, 2, intelligenceBar);
                        ProgressBarUtils.updateMoodBar(mainChar, 2, intelligenceBar);
                        activityLogText.append("Я прочитал захватывающую книгу. \n \n");
                        activityDisplay.setText(activityLogText);
                        scrollView.post(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.fullScroll(View.FOCUS_DOWN);
                            }
                        });
                    }
                    else if(n == 4) {
                        ProgressBarUtils.updateLooksBar(mainChar, 2, looksBar);
                        ProgressBarUtils.updateMoodBar(mainChar, 1, intelligenceBar);
                        activityLogText.append("Я позанимался в спортзале. \n \n");
                        activityDisplay.setText(activityLogText);
                        scrollView.post(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.fullScroll(View.FOCUS_DOWN);
                            }
                        });
                    }
                    activityCheck[0] = true;
                }
            }
        });


        nextYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainChar.setAge(mainChar.getAge() + 1);
                endGame();
                String randomEvent = EventUtils.generateEvent(mainChar);
                activityLogText.append("Возраст: " + mainChar.getAge() + "\n" + randomEvent);
                activityDisplay.setText(activityLogText);
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
                EventUtils.generateEvent(mainChar);
                activityCheck[0] = false;
            }
        });
    }

    public void endGame() {
        if (mainChar.getAge() == 120) {
            Intent endIntent = new Intent(this, EndGameActivity.class);

            startActivity(endIntent);
            finish();
        }
    }
}