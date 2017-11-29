package com.taesu.seoul2.Place_detail;

import java.io.Serializable;

/**
 * Created by park on 2017-09-26.
 */

public class Place1_model implements Serializable {

    int id1;
    private String name1,category1, phone1, address1, link1
            , size1, people1, placeimage1, placeimage2, placeimage3;

    private String rvImage1;

    private static final long seriaVersionUID = 1L;

    private boolean isSelected;


    public String getRvImage1() {
        return rvImage1;
    }

    public void setRvImage1(String rvImage1) {
        this.rvImage1 = rvImage1;
    }

    public Place1_model() {

    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1){
        this.id1=id1;
    }

    public String getName1(){
        return name1;
    }

    public void setName1(String name1) {
        this.name1=name1;
    }

    public String getCategory1(){
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1=category1;
    }

    public String getPhone1(){
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1=phone1;
    }

    public String getAddress1(){
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1=address1;
    }

    public String getLink1() {
        return link1;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }

    public String getSize1() {
        return size1;
    }

    public void setSize1(String size1) {
        this.size1 = size1;
    }

    public String getPeople1() {
        return people1;
    }

    public void setPeople1(String people1) {
        this.people1 = people1;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getPlaceimage1() {
        return placeimage1;
    }

    public void setPlaceimage1(String placeimage1) {
        this.placeimage1 = placeimage1;
    }

    public String getPlaceimage2() {
        return placeimage2;
    }

    public void setPlaceimage2(String placeimage2) {
        this.placeimage2 = placeimage2;
    }

    public String getPlaceimage3() {
        return placeimage3;
    }

    public void setPlaceimage3(String placeimage3) {
        this.placeimage3 = placeimage3;
    }
}
