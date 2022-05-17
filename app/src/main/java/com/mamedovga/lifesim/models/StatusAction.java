package com.mamedovga.lifesim.models;

public class StatusAction {
    private int image;
    private String name;
    private String description;
    private String label;

    public StatusAction(int image, String name, String description, String label) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.label = label;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
