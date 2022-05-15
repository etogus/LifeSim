package com.mamedovga.lifesim.models;

public class Car extends AbstractAsset {

    private String type;
    private int condition;

    public Car(String name, int price, int image, String type, int condition) {
        super(name, price, image);
        this.type = type;
        this.condition = condition;
    }

    public String getType() {
        return type;
    }

    public void setType(String carClass) {
        this.type = carClass;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
}
