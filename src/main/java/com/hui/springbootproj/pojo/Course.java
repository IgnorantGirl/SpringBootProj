package com.hui.springbootproj.pojo;


public class Course  {


    int cId;

    String name;

    public Course(int cId, String name) {
        this.cId= cId;
        this.name = name;
    }

    public Course() {
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }
}
