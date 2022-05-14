package com.mamedovga.lifesim.models;

import java.util.ArrayList;

public class BasicEvent {
    private int id;
    private String name;
    private int image;
    private String label;
    private String description;
    private ArrayList<String> actions;
    //private String resolution;

    public BasicEvent(int id, String name, int image, String label, String description, ArrayList<String> actions) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.label = label;
        this.description = description;
        //this.resolution = resolution;
        this.actions = actions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getActions() {
        return actions;
    }

    public void setActions(ArrayList<String> actions) {
        this.actions = actions;
    }

//    public String getResolution() {
//        return resolution;
//    }
//
//    public void setResolution(String resolution) {
//        this.resolution = resolution;
//    }
}
