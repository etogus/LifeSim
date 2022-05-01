package com.mamedovga.lifesim.utils;

import com.mackhartley.roundedprogressbar.RoundedProgressBar;
import com.mamedovga.lifesim.models.MainCharacter;


public class ProgressBarUtils {
    public static void updateMoodBar(MainCharacter mainCharacter, int diff, RoundedProgressBar progressBar) {
        int mood = mainCharacter.getMood();
        mainCharacter.setMood(mood+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }

    public static void updateHealthBar(MainCharacter mainCharacter, int diff, RoundedProgressBar progressBar) {
        int health = mainCharacter.getHealth();
        mainCharacter.setHealth(health+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }

    public static void updateIntellectBar(MainCharacter mainCharacter, int diff, RoundedProgressBar progressBar) {
        int intellect = mainCharacter.getIntelligence();
        mainCharacter.setIntelligence(intellect+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }

    public static void updateLooksBar(MainCharacter mainCharacter, int diff, RoundedProgressBar progressBar) {
        int looks = mainCharacter.getLooks();
        mainCharacter.setLooks(looks+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }
}
