package com.faramarz.tictacdev.gridviewapp.sample2;

public class CustomerModel {

    String name;
    String version;
    int id_;
    int image;

    public CustomerModel(String name, String version, int id_, int image) {
        this.name = name;
        this.version = version;
        this.id_ = id_;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }
}

