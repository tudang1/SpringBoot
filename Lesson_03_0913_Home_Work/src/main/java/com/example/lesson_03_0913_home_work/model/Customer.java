package com.example.lesson_03_0913_home_work.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer {
    private int id;
    private String fullname;
    private String email;
    private long telephone;

    public Customer() {
    }

    public Customer(int id, String fullname, String email, long telephone) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.telephone = telephone;
    }
}
