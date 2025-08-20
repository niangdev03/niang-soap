package com.soap.entity;

import java.io.Serializable;

public class Sector implements Serializable {
    private int id;
    private String name;

    public Sector() {}

    public Sector(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}