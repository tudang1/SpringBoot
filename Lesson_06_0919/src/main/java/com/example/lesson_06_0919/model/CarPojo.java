package com.example.lesson_06_0919.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarPojo {
    private String brand;
    private String manufacturer;
    private String photo;
}
