package com.example.geo.museumguide.events;

import java.io.Serializable;

/**
 * Created by Geo on 2/1/2017.
 */

public class Event implements Serializable {
    private String name;
    private String description;
    private String date;
    private String path;

    public Event(){

    }

    public Event(String name, String description, String date, String path) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.path = path;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
