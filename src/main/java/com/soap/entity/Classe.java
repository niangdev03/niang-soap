package com.soap.entity;

public class Classe {
    private int id;
    private String name;
    private String description;
    private Sector sector; // au lieu de sectorId

    public Classe() {}

    public Classe(int id, String name, String description, int sectorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sector = new Sector(sectorId, null); // le nom sera rempli plus tard
    }


    public Classe(int id, String name, String description, Sector sector) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sector = sector;
    }

    // Getters / Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Sector getSector() { return sector; }
    public void setSector(Sector sector) { this.sector = sector; }
}