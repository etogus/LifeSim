package com.mamedovga.lifesim.models;

public class Job {
    String name;
    int image;
    String description;
    int salary;

    public Job(String name, int image, String description, int salary) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.salary = salary;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
