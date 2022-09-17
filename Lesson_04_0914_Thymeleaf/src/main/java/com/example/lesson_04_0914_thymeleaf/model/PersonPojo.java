package com.example.lesson_04_0914_thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonPojo {
    private String name;
    private String job;
    private String gender;
    private String birthdate;
}
