package com.taesu.seoul2.Place_detail;

import java.io.Serializable;

/**
 * Created by park on 2017-10-18.
 */

public class Place2_model implements Serializable{

    int id2;
    private String name2,category2, phone2, address2, link2
            , size2, people2, placeimage21, placeimage22, placeimage23;

    private static final long seriaVersionUID2 = 1L;

    private boolean isSelected2;

    public Place2_model() {

    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getLink2() {
        return link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    public String getSize2() {
        return size2;
    }

    public void setSize2(String size2) {
        this.size2 = size2;
    }

    public String getPeople2() {
        return people2;
    }

    public void setPeople2(String people2) {
        this.people2 = people2;
    }

    public boolean isSelected2() {
        return isSelected2;
    }

    public void setSelected2(boolean selected2) {
        isSelected2 = selected2;
    }

    public String getPlaceimage21() {
        return placeimage21;
    }

    public void setPlaceimage21(String placeimage21) {
        this.placeimage21 = placeimage21;
    }

    public String getPlaceimage22() {
        return placeimage22;
    }

    public void setPlaceimage22(String placeimage22) {
        this.placeimage22 = placeimage22;
    }

    public String getPlaceimage23() {
        return placeimage23;
    }

    public void setPlaceimage23(String placeimage23) {
        this.placeimage23 = placeimage23;
    }
}
