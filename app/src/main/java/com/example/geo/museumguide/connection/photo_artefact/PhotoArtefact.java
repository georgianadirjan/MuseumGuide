package com.example.geo.museumguide.connection.photo_artefact;

import com.example.geo.museumguide.model.AbstractDataModel;

import java.io.Serializable;

/**
 * Created by Geo on 2/7/2017.
 */

public class PhotoArtefact extends AbstractDataModel implements Serializable{
    private Long id;
    private String name;
    private String author;
    private String path;
    private Long year;
    private Long artefactId;
    private long views;
    private boolean favorite;

    public PhotoArtefact(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getArtefactId() {
        return artefactId;
    }

    public void setArtefactId(Long artefactId) {
        this.artefactId = artefactId;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }
}
