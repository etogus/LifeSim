package com.mamedovga.lifesim.models;

public class NPCharacter extends Person {
    private String affinity;
    private String relation;

    public NPCharacter(String name, String lastName, String gender, String country,
                       int age, int energy, String affinity, String relation) {
        super(name, lastName, gender, country, age, energy);
        this.affinity = affinity;
        this.relation = relation;
    }

    public String getAffinity() {
        return affinity;
    }

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
