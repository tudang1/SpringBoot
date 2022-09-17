package com.example.lesson_05_0916_thymeleafcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int id;
    private String fullname;
    private String email;
    private long phone;
}
