package com.mamedovga.lifesim.models;

import java.util.ArrayList;

public class MainCharacter extends Person {

    private ArrayList<NPCharacter> family;
    private ArrayList<NPCharacter> friends;
    private ArrayList<NPCharacter> lovers;
    private ArrayList<NPCharacter> coworkers;
    private ArrayList<NPCharacter> enemies;
    private ArrayList<Property> properties;

    public MainCharacter(String name, String lastName, String gender, String country,
                         int age, int energy, ArrayList<NPCharacter> family,
                         ArrayList<NPCharacter> friends, ArrayList<NPCharacter> lovers,
                         ArrayList<NPCharacter> coworkers, ArrayList<NPCharacter> enemies,
                         ArrayList<Property> properties) {
        super(name, lastName, gender, country, age, energy);
        this.family = family;
        this.friends = friends;
        this.lovers = lovers;
        this.coworkers = coworkers;
        this.enemies = enemies;
        this.properties = properties;
    }
}
