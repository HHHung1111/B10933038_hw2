package com.example.b10933038_hw2;
import java.io.Serializable;

public class University implements Serializable {
    private String name;
    private String description;
    private int imageResourceId;

    public University(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}

