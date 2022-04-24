package com.mamedovga.lifesim.models;

import com.mamedovga.lifesim.R;

import java.util.ArrayList;

public class Person {

    private String name;
    private String lastName;
    private String gender;
    private String country;
    private int age;
    private int mood;
    private int health;
    private int intelligence;
    private int looks;
    private int energy;
    private int karma;
    private String[] maleStatus = {"Новорожденный", "Дитя", "Ребёнок", "Школьник", "Студент", "Молодой человек"};
    private String[] femaleStatus = {"Новорожденная", "Дитя", "Ребёнок", "Школьница", "Студентка", "Девушка"};

    public Person() {}

    public Person(String name, String lastName, String gender, String country, int age) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getName() + " " + getLastName();
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getLooks() {
        return looks;
    }

    public void setLooks(int looks) {
        this.looks = looks;
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setPersonStats (int mood, int health, int intelligence, int looks, int energy) {
        this.mood = mood;
        this.health = health;
        this.intelligence = intelligence;
        this.looks = looks;
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
