package com.example.geo.museumguide.beacon;

import com.estimote.sdk.cloud.model.Color;

public class EstimoteCloudBeaconDetails {

    private String beaconName;
    private Color beaconColor;
    private int minor;

    private int major;
    private String uuid;

    public EstimoteCloudBeaconDetails(String beaconName, Color beaconColor, int minor, int major, String uuid) {
        this.beaconName = beaconName;
        this.beaconColor = beaconColor;
        this.minor=minor;
        this.major=major;
        this.uuid = uuid;
    }

    public String getBeaconName() {
        return beaconName;
    }

    public Color getBeaconColor() {
        return beaconColor;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "[beaconName: " + getBeaconName() + ", beaconColor: " + getBeaconColor() + "]";
    }
}
