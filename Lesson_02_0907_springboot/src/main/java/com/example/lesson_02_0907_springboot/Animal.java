package com.example.lesson_02_0907_springboot;

public class Animal {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
