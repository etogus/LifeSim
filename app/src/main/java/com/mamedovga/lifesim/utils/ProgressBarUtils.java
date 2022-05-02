package com.mamedovga.lifesim.utils;

import com.mackhartley.roundedprogressbar.RoundedProgressBar;
import com.mamedovga.lifesim.models.MainCharacter;
import com.mamedovga.lifesim.models.MainCharacterViewModel;


public class ProgressBarUtils {
    public static void updateMoodBar(MainCharacterViewModel mainCharacter, int diff, RoundedProgressBar progressBar) {
        int mood = mainCharacter.getMood().getValue();
        mainCharacter.setMood(mood+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }

    public static void updateHealthBar(MainCharacterViewModel mainCharacter, int diff, RoundedProgressBar progressBar) {
        int health = mainCharacter.getHealth().getValue();
        mainCharacter.setHealth(health+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }

    public static void updateIntellectBar(MainCharacterViewModel mainCharacter, int diff, RoundedProgressBar progressBar) {
        int intellect = mainCharacter.getIntelligence().getValue();
        mainCharacter.setIntelligence(intellect+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }

    public static void updateLooksBar(MainCharacterViewModel mainCharacter, int diff, RoundedProgressBar progressBar) {
        int looks = mainCharacter.getLooks().getValue();
        mainCharacter.setLooks(looks+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }

    public static void updateEnergyBar(MainCharacterViewModel mainCharacter, int diff, RoundedProgressBar progressBar) {
        int looks = mainCharacter.getEnergy().getValue();
        mainCharacter.setEnergy(looks+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }
}
