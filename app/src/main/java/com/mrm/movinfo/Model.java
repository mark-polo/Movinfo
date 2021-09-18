package com.mrm.movinfo;

public class Model {
    private int id;
    private String name;
    private String year;
    private String director;
    private String description;

    public Model() { }

    public Model(int id, String name, String year, String director, String description) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}