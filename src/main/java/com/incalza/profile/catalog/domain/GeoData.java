package com.incalza.profile.catalog.domain;

/**
 * Created by sincalza on 06/03/2017.
 */
public class GeoData {

    private final double latitude;
    private final double longitude;


    public GeoData(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
