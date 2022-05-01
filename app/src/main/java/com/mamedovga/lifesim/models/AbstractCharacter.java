package com.mamedovga.lifesim.models;

public abstract class AbstractCharacter {
    public String name;
    public String lastName;
    public String gender;
    public String country;
    public int age;
    public int mood;
    public int health;
    public int intelligence;
    public int looks;
    public int karma;
    public int money;
    public int avatar;

    public void setData(String name, String lastName, String gender, String country, int age) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.age = age;
    }

    public void setStats (int mood, int health, int intelligence, int looks, int energy) {
        this.mood = mood;
        this.health = health;
        this.intelligence = intelligence;
        this.looks = looks;
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

    public int getMoney() {
        return money;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
