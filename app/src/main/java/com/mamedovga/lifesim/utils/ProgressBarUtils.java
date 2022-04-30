package com.mamedovga.lifesim.utils;

import com.mackhartley.roundedprogressbar.RoundedProgressBar;
import com.mamedovga.lifesim.models.Person;


public class ProgressBarUtils {
    public static void updateMoodBar(Person person, int diff, RoundedProgressBar progressBar) {
        int mood = person.getMood();
        person.setMood(mood+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }

    public static void updateHealthBar(Person person, int diff, RoundedProgressBar progressBar) {
        int health = person.getHealth();
        person.setHealth(health+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }

    public static void updateIntellectBar(Person person, int diff, RoundedProgressBar progressBar) {
        int intellect = person.getIntelligence();
        person.setIntelligence(intellect+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }

    public static void updateLooksBar(Person person, int diff, RoundedProgressBar progressBar) {
        int looks = person.getLooks();
        person.setLooks(looks+diff);
        progressBar.setProgressPercentage(progressBar.getProgressPercentage() + diff, true);
    }
}
