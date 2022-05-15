package com.mamedovga.lifesim.models;

public class Book extends AbstractAsset {

    private String type;
    private int pages;

    public Book(String name, int price, int image, String type, int pages) {
        super(name, price, image);
        this.type = type;
        this.pages = pages;
    }

    public String getType() {
        return type;
    }

    public void setType(String genre) {
        this.type = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
