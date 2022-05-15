package com.mamedovga.lifesim.models;

public class Sport extends AbstractAsset {

    private String type;

    public Sport(String name, int price, int image, String type) {
        super(name, price, image);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
