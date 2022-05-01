package com.mamedovga.lifesim.models;

public class NonPlayableCharacter extends AbstractCharacter {

    private int affinity;
    private String statusToPlayer;

    public NonPlayableCharacter(String name, String lastName, String gender, String country, int age, int affinity) {
        super.setData(name, lastName, gender, country, age);
        this.affinity = affinity;
    }

    public void setStats (int mood, int health, int intelligence, int looks, int energy, int money) {
        super.setStats(mood, health, intelligence, looks, energy);
        super.money = money;
    }

    public int getAffinity() {
        return affinity;
    }

    public void setAffinity(int affinity) {
        this.affinity = affinity;
    }

    public String getStatusToPlayer() {
        return statusToPlayer;
    }

    public void setStatusToPlayer(String statusToPlayer) {
        this.statusToPlayer = statusToPlayer;
    }
}
