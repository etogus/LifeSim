package com.mamedovga.lifesim;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.navigation.NavigationBarView;
import com.mamedovga.lifesim.databinding.ActivityGameBinding;
import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.models.Person;
import com.mamedovga.lifesim.utils.PersonUtils;

public class GameActivity extends AppCompatActivity {

    private ActivityGameBinding binding;
    private boolean activityCheck = false;

    private MainCharacterViewModel mainCharacterViewModel;

    private final StatusFragment statusFragment = new StatusFragment();
    private final AssetsFragment assetsFragment = new AssetsFragment();
    private final RelationshipsFragment relationshipsFragment = new RelationshipsFragment();
    private final ActionsFragment actionsFragment = new ActionsFragment();
    private Fragment active = statusFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String playerName = intent.getStringExtra("firstName");
        String playerLastName = intent.getStringExtra("lastName");
        String playerGender = intent.getStringExtra("gender");
        String playerCountry = intent.getStringExtra("country");
        int playerAge = 0;
        Person samplePerson = new Person(playerName, playerLastName, playerGender, playerCountry, playerAge);
        PersonUtils.randomizeStats(samplePerson);

        mainCharacterViewModel = ViewModelProviders.of(this).get(MainCharacterViewModel.class);
        mainCharacterViewModel.setName(samplePerson.getName());
        mainCharacterViewModel.setLastName(samplePerson.getLastName());
        mainCharacterViewModel.setGender(samplePerson.getGender());
        mainCharacterViewModel.setCountry(samplePerson.getCountry());
        mainCharacterViewModel.setAge(samplePerson.getAge());
        mainCharacterViewModel.setMood(samplePerson.getMood());
        mainCharacterViewModel.setHealth(samplePerson.getHealth());
        mainCharacterViewModel.setIntelligence(samplePerson.getIntelligence());
        mainCharacterViewModel.setLooks(samplePerson.getLooks());
        mainCharacterViewModel.setEnergy(samplePerson.getEnergy());
        mainCharacterViewModel.setKarma(samplePerson.getKarma());

        getSupportFragmentManager().beginTransaction().add(R.id.topAndMiddleContainer, actionsFragment, "4").hide(actionsFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.topAndMiddleContainer, relationshipsFragment, "3").hide(relationshipsFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.topAndMiddleContainer, assetsFragment, "2").hide(assetsFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.topAndMiddleContainer, statusFragment, "1").commit();

        //getSupportFragmentManager().beginTransaction().replace(R.id.topAndMiddleContainer, statusFragment).commit();

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        statusButton();
                        break;
                    case R.id.page_2:
                        assetsButton();
                        break;
                    case R.id.page_3:
                        relationShipsButton();
                        break;
                    case R.id.page_4:
                        actionsButton();
                        break;
                }
                return true;
            }
        });

        binding.floatingActionButton.setOnClickListener(view1 -> nextYear());
    }

    public void statusButton() {
        getSupportFragmentManager().beginTransaction().hide(active).show(statusFragment).commit();
        active = statusFragment;
        //getSupportFragmentManager().beginTransaction().replace(R.id.topAndMiddleContainer, statusFragment).commit();
    }

    public void assetsButton() {
        getSupportFragmentManager().beginTransaction().hide(active).show(assetsFragment).commit();
        active = assetsFragment;
        //getSupportFragmentManager().beginTransaction().replace(R.id.topAndMiddleContainer, assetsFragment).commit();
    }

    public void relationShipsButton() {
        //startActivity(new Intent(this, ChatActivity.class));
        getSupportFragmentManager().beginTransaction().hide(active).show(relationshipsFragment).commit();
        active = relationshipsFragment;
        //getSupportFragmentManager().beginTransaction().replace(R.id.topAndMiddleContainer, relationshipsFragment).commit();
    }

    public void actionsButton() {
        //getSupportFragmentManager().beginTransaction().replace(binding.topAndMiddleContainer.getId(), actionsFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(active).show(actionsFragment).commit();
        active = actionsFragment;
//        if(!activityCheck) {
//            int n = NumberUtils.getRandomNumber(1, 4);
//            if(n == 1) {
//                ProgressBarUtils.updateMoodBar(mainChar, 1, binding.moodBar);
//                activityLogText.append("Я посмотрел интересный фильм. \n \n");
//                binding.activityDisplay.setText(activityLogText);
//                binding.activityLog.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        binding.activityLog.fullScroll(View.FOCUS_DOWN);
//                    }
//                });
//            }
//            else if(n == 2) {
//                ProgressBarUtils.updateHealthBar(mainChar, 1, binding.healthBar);
//                ProgressBarUtils.updateMoodBar(mainChar, 1, binding.moodBar);
//                activityLogText.append("Я сходил на пробежку. Чувствую себя сильнее. \n \n");
//                binding.activityDisplay.setText(activityLogText);
//                binding.activityLog.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        binding.activityLog.fullScroll(View.FOCUS_DOWN);
//                    }
//                });
//            }
//            else if(n == 3) {
//                ProgressBarUtils.updateIntellectBar(mainChar, 2, binding.smartsBar);
//                ProgressBarUtils.updateMoodBar(mainChar, 2, binding.moodBar);
//                activityLogText.append("Я прочитал захватывающую книгу. \n \n");
//                binding.activityDisplay.setText(activityLogText);
//                binding.activityLog.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        binding.activityLog.fullScroll(View.FOCUS_DOWN);
//                    }
//                });
//            }
//            else if(n == 4) {
//                ProgressBarUtils.updateLooksBar(mainChar, 2, binding.looksBar);
//                ProgressBarUtils.updateMoodBar(mainChar, 1, binding.moodBar);
//                activityLogText.append("Я позанимался в спортзале. \n \n");
//                binding.activityDisplay.setText(activityLogText);
//                binding.activityLog.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        binding.activityLog.fullScroll(View.FOCUS_DOWN);
//                    }
//                });
//            }
//            activityCheck = true;
//        }
    }

    public void nextYear() {
        if(statusFragment.isEndGame()) {
            Intent endIntent = new Intent(this, EndGameActivity.class);
            startActivity(endIntent);
            finish();
        }
        statusFragment.nextYear();
        activityCheck = false;
    }
}