package com.example.firebaseapp;

public class User {

    private String name;
    private String email;
    private String phone;
    private String id;
//    static int count=0;
    public User() {}

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
//        this.id =(++count)+"";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getId() {
//        return id;
//    }
}
