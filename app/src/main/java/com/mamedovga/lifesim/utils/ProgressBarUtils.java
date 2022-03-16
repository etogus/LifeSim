package com.mamedovga.lifesim.utils;

import android.widget.ProgressBar;

import com.mamedovga.lifesim.models.Person;


public class ProgressBarUtils {
    public static void updateMoodBar(Person person, int diff, ProgressBar progressBar) {
        int mood = person.getMood();
        person.setMood(mood+diff);
        progressBar.incrementProgressBy(diff);
    }

    public static void updateHealthBar(Person person, int diff, ProgressBar progressBar) {
        int health = person.getHealth();
        person.setHealth(health+diff);
        progressBar.incrementProgressBy(diff);
    }

    public static void updateIntellectBar(Person person, int diff, ProgressBar progressBar) {
        int intellect = person.getIntelligence();
        person.setIntelligence(intellect+diff);
        progressBar.incrementProgressBy(diff);
    }

    public static void updateLooksBar(Person person, int diff, ProgressBar progressBar) {
        int looks = person.getLooks();
        person.setLooks(looks+diff);
        progressBar.incrementProgressBy(diff);
    }
}
