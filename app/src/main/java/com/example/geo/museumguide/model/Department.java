package com.example.geo.museumguide.model;

import java.util.ArrayList;

/**
 * Created by Geo on 1/1/2017.
 */

public class Department extends AbstractBeaconObservable {

    private String name;
    private String details;
    private ArrayList<Artefact> artefacts;
    private Long idBeacon;
    private long views;
    private boolean favorite;

    public Department(){

    }

    public Department(String name, String details, ArrayList<Artefact> artefacts, Long idBeacon, long views, boolean favorite) {
        this.name = name;
        this.details = details;
        this.artefacts = artefacts;
        this.idBeacon = idBeacon;
        this.views = views;
        this.favorite = favorite;
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



    public Long getIdBeacon() {
        return idBeacon;
    }

    public void setIdBeacon(Long idBeacon) {
        this.idBeacon = idBeacon;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public ArrayList<Artefact> getArtefacts() {
        return artefacts;
    }

    public void setArtefacts(ArrayList<Artefact> artefacts) {
        this.artefacts = artefacts;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
