package com.example.geo.museumguide.events.task;

/**
 * Created by Geo on 2/3/2017.
 */

public class PhotoDepartmentBean {

    private Long id;
    private String name;
    private String description;
    private String date;
    private String path;
    private long views;
    private boolean favorite;

    public PhotoDepartmentBean(){

    }
    public PhotoDepartmentBean(Long id, String name, String description, String date, String path) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.path = path;
    }

    public PhotoDepartmentBean(Long id, String name, String description, String date, String path, long views, boolean favorite) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.path = path;
        this.views = views;
        this.favorite = favorite;
    }

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
