package com.example.user.listview;


public class Places {

    private int id;
    private String name;
    private String type;
    private int countryId;
    public Places(int id, int countryId , String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.countryId=countryId;
    }

    public Places(Places user) {
        this.id = user.id;
        this.name = user.name;
        this.type = user.type;
        this.countryId=user.countryId;
    }

    public int getId() {
        return id;
    }
    public int countryId() {
        return countryId;
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
