package com.example.lesson_02_0910;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson020910Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson020910Application.class, args);
//        System.out.println(PersonRepository.countPeopleByNationality());
        System.out.println(PersonRepository.countPeopleNationality());
    }

}
