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
import com.mamedovga.lifesim.models.MainCharacter;
import com.mamedovga.lifesim.utils.PersonUtils;

public class GameActivity extends AppCompatActivity {

    private ActivityGameBinding binding;
    private boolean activityCheck = false;

    private MainCharacterViewModel mainCharacterViewModel;

    private final StatusFragment statusFragment = new StatusFragment();
    private final AssetsFragment assetsFragment = new AssetsFragment();
    private final RelationshipsFragment relationshipsFragment = new RelationshipsFragment();
    private final ActionsFragment actionsFragment = new ActionsFragment();
    private final RelationshipDialogFragment relationshipDialogFragment = new RelationshipDialogFragment();
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
        int[] playerAvatar = intent.getIntArrayExtra("avatar");
        int playerAge = 0;
        MainCharacter sampleMainCharacter = new MainCharacter(playerName, playerLastName, playerGender, playerCountry, playerAge);
        PersonUtils.randomizeStats(sampleMainCharacter);

        mainCharacterViewModel = ViewModelProviders.of(this).get(MainCharacterViewModel.class);
        mainCharacterViewModel.setName(sampleMainCharacter.getName());
        mainCharacterViewModel.setLastName(sampleMainCharacter.getLastName());
        mainCharacterViewModel.setGender(sampleMainCharacter.getGender());
        mainCharacterViewModel.setCountry(sampleMainCharacter.getCountry());
        mainCharacterViewModel.setAge(sampleMainCharacter.getAge());
        mainCharacterViewModel.setMood(sampleMainCharacter.getMood());
        mainCharacterViewModel.setHealth(sampleMainCharacter.getHealth());
        mainCharacterViewModel.setIntelligence(sampleMainCharacter.getIntelligence());
        mainCharacterViewModel.setLooks(sampleMainCharacter.getLooks());
        mainCharacterViewModel.setEnergy(sampleMainCharacter.getEnergy());
        mainCharacterViewModel.setKarma(sampleMainCharacter.getKarma());
        mainCharacterViewModel.setAvatar(playerAvatar);
        mainCharacterViewModel.setActivityLogText(new StringBuilder().append("Возраст: ").append(0).append("\n").append("Я родился."));

        getSupportFragmentManager().beginTransaction().add(R.id.topAndMiddleContainer, actionsFragment, "actionsFragment").hide(actionsFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.topAndMiddleContainer, relationshipsFragment, "relationshipsFragment").hide(relationshipsFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.topAndMiddleContainer, assetsFragment, "assetsFragment").hide(assetsFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.topAndMiddleContainer, statusFragment, "statusFragment").commit();

        //getSupportFragmentManager().beginTransaction().replace(R.id.topAndMiddleContainer, statusFragment).commit();

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        statusButton();
                        binding.floatingActionButton.show();
                        break;
                    case R.id.page_2:
                        assetsButton();
                        binding.floatingActionButton.hide();
                        break;
                    case R.id.page_3:
                        relationShipsButton();
                        binding.floatingActionButton.hide();
                        break;
                    case R.id.page_4:
                        actionsButton();
                        binding.floatingActionButton.hide();
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