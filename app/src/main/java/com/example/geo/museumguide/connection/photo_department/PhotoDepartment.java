package com.example.geo.museumguide.connection.photo_department;

import com.example.geo.museumguide.model.AbstractDataModel;

import java.io.Serializable;

/**
 * Created by Geo on 2/8/2017.
 */

public class PhotoDepartment  extends AbstractDataModel implements Serializable {

    private Long id;
    private String name;
    private String path;
    private String description;
    private String date;
    private Long departmentId;
    private boolean favorite;
    private long views;


    public PhotoDepartment(){

    };
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "PhotoDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", departmentId=" + departmentId +
                ", favorite=" + favorite +
                '}';
    }
}
