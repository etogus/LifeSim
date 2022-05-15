package com.mamedovga.lifesim.models;

public class House extends AbstractAsset {

    private String type;
    private int rooms;
    private int condition;

    public House(String name, int price, int image, String type, int rooms, int condition) {
        super(name, price, image);
        this.type = type;
        this.rooms = rooms;
        this.condition = condition;
    }

    public String getType() {
        return type;
    }

    public void setType(String houseClass) {
        this.type = houseClass;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
}
