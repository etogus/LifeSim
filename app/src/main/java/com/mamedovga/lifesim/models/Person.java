package com.mamedovga.lifesim.models;

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
    private int karma;

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

    public void setPersonStats (int mood, int health, int intelligence, int looks) {
        this.mood = mood;
        this.health = health;
        this.intelligence = intelligence;
        this.looks = looks;
    }
}
