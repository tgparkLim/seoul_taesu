package com.taesu.seoul2.MainActivity_detail;

/**
 * Created by park on 2017-10-31.
 */

public class MarkerItem {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MarkerItem(int id, double lat, double lon, String name) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
    }

    int id;
    double lat;
    double lon;
    int price;

    public MarkerItem(double lat, double lon, String name) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MarkerItem(double lat, double lon, int price) {
        this.lat = lat;
        this.lon = lon;
        this.price = price;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}


