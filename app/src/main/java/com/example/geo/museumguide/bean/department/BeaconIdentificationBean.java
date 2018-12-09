package com.example.geo.museumguide.bean.department;

public class BeaconIdentificationBean {

    private String uuid;
    private Integer major;
    private Integer minor;

    public BeaconIdentificationBean(){

    }

    public BeaconIdentificationBean(String uuid, Integer major, Integer minor) {
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

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Integer getMinor() {
        return minor;
    }

    public void setMinor(Integer minor) {
        this.minor = minor;
    }

}
