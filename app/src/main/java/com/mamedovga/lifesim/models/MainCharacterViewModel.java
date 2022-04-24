package com.mamedovga.lifesim.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainCharacterViewModel extends ViewModel {

    private MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<String> lastName = new MutableLiveData<>();
    private MutableLiveData<String> gender = new MutableLiveData<>();
    private MutableLiveData<String> country = new MutableLiveData<>();
    private MutableLiveData<Integer> age = new MutableLiveData<>();
    private MutableLiveData<Integer> mood = new MutableLiveData<>();
    private MutableLiveData<Integer> health = new MutableLiveData<>();
    private MutableLiveData<Integer> intelligence = new MutableLiveData<>();
    private MutableLiveData<Integer> looks = new MutableLiveData<>();
    private MutableLiveData<Integer> energy = new MutableLiveData<>();
    private MutableLiveData<Integer> karma = new MutableLiveData<>();

    public void setName(String s) {
        name.setValue(s);
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setLastName(String s) {
        lastName.setValue(s);
    }

    public MutableLiveData<String> getLastName() {
        return lastName;
    }

    public void setGender(String s) {
        gender.setValue(s);
    }

    public MutableLiveData<String> getGender() {
        return gender;
    }

    public void setCountry(String s) {
        country.setValue(s);
    }

    public MutableLiveData<String> getCountry() {
        return country;
    }

    public void setAge(Integer i) {
        age.setValue(i);
    }

    public MutableLiveData<Integer> getAge() {
        return age;
    }

    public void setMood(Integer i) {
        mood.setValue(i);
    }

    public MutableLiveData<Integer> getMood() {
        return mood;
    }

    public void setHealth(Integer i) {
        health.setValue(i);
    }

    public MutableLiveData<Integer> getHealth() {
        return health;
    }

    public void setIntelligence(Integer i) {
        intelligence.setValue(i);
    }

    public MutableLiveData<Integer> getIntelligence() {
        return intelligence;
    }

    public void setLooks(Integer i) {
        looks.setValue(i);
    }

    public MutableLiveData<Integer> getLooks() {
        return looks;
    }

    public void setEnergy(Integer i) {
        energy.setValue(i);
    }

    public MutableLiveData<Integer> getEnergy() {
        return energy;
    }

    public void setKarma(Integer i) {
        karma.setValue(i);
    }

    public MutableLiveData<Integer> getKarma() {
        return karma;
    }
}
