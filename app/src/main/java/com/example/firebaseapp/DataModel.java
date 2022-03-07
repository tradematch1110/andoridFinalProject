package com.example.firebaseapp;

public class DataModel {

    String name;
    String version;
    int id_;
//    int image;

    public DataModel(String name,  int id_) {
        this.name = name;
        this.id_ = id_;
//        this.image=image;
    }


    public String getName() {
        return name;
    }


    public String getVersion() {
        return version;
    }

//    public int getImage() {
//        return image;
//    }

    public int getId() {
        return id_;
    }
}