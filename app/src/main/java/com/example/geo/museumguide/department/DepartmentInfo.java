package com.example.geo.museumguide.department;

import com.example.geo.museumguide.model.AbstractBeaconObservable;

import java.io.Serializable;

/**
 * Created by Geo on 2/11/2017.
 */

public class DepartmentInfo  implements Serializable{

    private int id;
    private String name;
    private String details;
    private long beaconId;
    private long views;
    private boolean favorite;


    public DepartmentInfo(){}


    public DepartmentInfo(int id, String name, String details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public DepartmentInfo(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public DepartmentInfo(int id, String name, String details, long beaconId) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.beaconId = beaconId;
    }

    public DepartmentInfo(int id, String name, String details, long beaconId, long views, boolean favorite) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.beaconId = beaconId;
        this.views = views;
        this.favorite = favorite;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public long getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(long beaconId) {
        this.beaconId = beaconId;
    }

    @Override
    public String toString() {
        return "DepartmentInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", beaconId=" + beaconId +
                ", views=" + views +
                ", favorite=" + favorite +
                '}';
    }
}
