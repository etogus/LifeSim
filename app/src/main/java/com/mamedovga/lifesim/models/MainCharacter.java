package com.mamedovga.lifesim.models;

public class MainCharacter extends AbstractCharacter {

    private int energy;

    private final String[] maleStatus = {"Новорожденный", "Дитя", "Ребёнок", "Школьник", "Студент", "Молодой человек"};
    private final String[] femaleStatus = {"Новорожденная", "Дитя", "Ребёнок", "Школьница", "Студентка", "Девушка"};

    public MainCharacter() {}

    public MainCharacter(String name, String lastName, String gender, String country, int age) {
        super.setData(name, lastName, gender, country, age);
    }

    @Override
    public void setStats (int mood, int health, int intelligence, int looks, int energy) {
        super.setStats(mood, health, intelligence, looks, energy);
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getMaleStatus(int age) {
        if(age == 0) {
            return maleStatus[0];
        } else if(age > 0 && age < 3) {
            return maleStatus[1];
        } else if(age >= 3 && age < 5) {
            return maleStatus[2];
        } else if(age >= 5 && age < 7) {
            return maleStatus[3];
        } else if(age >= 7 && age < 19) {
            return maleStatus[4];
        } else if(age >= 23) {
            return maleStatus[5];
        } else return "Неопределённый статус";
    }

    public String getFemaleStatus(int age) {
        if(age == 0) {
            return femaleStatus[0];
        } else if(age > 0 && age < 3) {
            return femaleStatus[1];
        } else if(age >= 3 && age < 5) {
            return femaleStatus[2];
        } else if(age >= 5 && age < 7) {
            return femaleStatus[3];
        } else if(age >= 7 && age < 19) {
            return femaleStatus[4];
        } else if(age >= 23) {
            return femaleStatus[5];
        } else return "Неопределённый статус";
    }
}
