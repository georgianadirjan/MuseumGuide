package com.example.geo.museumguide.model;

import java.io.Serializable;

/**
 * Created by Geo on 1/1/2017.
 */

public class Artefact extends AbstractNFCObservable implements Serializable {

    private int id;
    private String title;
    private String author;
    private int year;
    private String description;
    private int department_id;
    private long views;
    private boolean favorite;

    public Artefact(){
    }

    public Artefact(int id, String title, String author, int year, String description, int department_id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.department_id = department_id;
    }

    public Artefact(String title, String author, int year, String description) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
    }


    public Artefact(String title, String author, int year, String description, int department_id) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.department_id = department_id;
    }

    public Artefact(int id, String title, String author, int year, String description, int department_id, long views, boolean favorite) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.department_id = department_id;
        this.views = views;
        this.favorite = favorite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
