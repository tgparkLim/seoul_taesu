package com.taesu.seoul2.Place_detail;

import java.io.Serializable;

/**
 * Created by park on 2017-10-19.
 */

public class Place3_model implements Serializable {

    int id3;
    private String name3, category3, phone3, address3, link3, size3, people3, placeimage31, placeimage32, placeimage33;

    private static final long seriaVersionUID3 = 1L;

    private boolean isSelected3;

    public Place3_model() {

    }

    public String getPlaceimage31() {
        return placeimage31;
    }

    public void setPlaceimage31(String placeimage31) {
        this.placeimage31 = placeimage31;
    }

    public String getPlaceimage32() {
        return placeimage32;
    }

    public void setPlaceimage32(String placeimage32) {
        this.placeimage32 = placeimage32;
    }

    public String getPlaceimage33() {
        return placeimage33;
    }

    public void setPlaceimage33(String placeimage33) {
        this.placeimage33 = placeimage33;
    }

    public int getId3() {
        return id3;
    }

    public void setId3(int id3) {
        this.id3 = id3;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getLink3() {
        return link3;
    }

    public void setLink3(String link3) {
        this.link3 = link3;
    }

    public String getSize3() {
        return size3;
    }

    public void setSize3(String size3) {
        this.size3 = size3;
    }

    public String getPeople3() {
        return people3;
    }

    public void setPeople3(String people3) {
        this.people3 = people3;
    }

    public boolean isSelected3() {
        return isSelected3;
    }

    public void setSelected3(boolean selected3) {
        isSelected3 = selected3;
    }
}
