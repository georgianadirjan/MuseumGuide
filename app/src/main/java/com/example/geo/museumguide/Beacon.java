package com.example.geo.museumguide;

/**
 * Created by Geo on 11/26/2016.
 */

public class Beacon extends AbstractBeaconObservable{

    private Long id;
    private String uuid;
    private int major;
    private int minor;


  public Beacon(){

  }

    public Beacon(String uuid, int major, int minor) {
        this.uuid = uuid;
        this.major = major;
        this.minor = minor;

    }

    public Beacon(Long id, String uuid, int major, int minor, String text) {
        this.id = id;
        this.uuid = uuid;
        this.major = major;
        this.minor = minor;

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }



    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
