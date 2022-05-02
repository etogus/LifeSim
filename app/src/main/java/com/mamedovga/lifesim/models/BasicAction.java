package com.mamedovga.lifesim.models;

public class BasicAction {
    private int image;
    private String name;
    private String description;
    private String label;
    private int energy;

    public BasicAction(int image, String name, String description, String label, int energy) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.label = label;
        this.energy = energy;
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
