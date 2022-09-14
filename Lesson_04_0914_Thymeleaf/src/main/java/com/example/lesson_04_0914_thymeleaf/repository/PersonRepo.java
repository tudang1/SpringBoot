package com.example.lesson_04_0914_thymeleaf.repository;

import com.example.lesson_04_0914_thymeleaf.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepo {
    private List<Person> people;
    public PersonRepo() {
        people = new ArrayList<>(List.of(
                new Person(1,"Dang Hong Tu","Maketting","Male","20-12-1995"),
                new Person(1,"Dang Hong A","fuho","Female","20-12-2000"),
                new Person(1,"Dang Van B","Sale","Male","09-03-1997")));

    }
    public List<Person> getPeople() {
        return people;
    }
}
