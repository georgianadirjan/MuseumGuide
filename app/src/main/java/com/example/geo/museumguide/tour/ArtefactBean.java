package com.example.geo.museumguide.tour;

import java.io.Serializable;

/**
 * Created by Geo on 1/28/2017.
 */

public class ArtefactBean implements Serializable{
    private Long id;
    private String author;
    private String description;
    private String title;
    private Integer year;
    private long views;
    private boolean favorite;

    public ArtefactBean(Long id, String author, String description, String title, Integer year) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.title = title;
        this.year = year;
    }

    public ArtefactBean(String author, String description, String title, Integer year) {
        this.author = author;
        this.description = description;
        this.title = title;
        this.year = year;
    }

    public ArtefactBean(Long id, String author, String description, String title, Integer year, long views, boolean favorite) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.title = title;
        this.year = year;
        this.views = views;
        this.favorite = favorite;
    }

    public ArtefactBean(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
