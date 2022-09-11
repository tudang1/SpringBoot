package com.example.lesson_02_0910;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Service
public class PersonRepository {
    private static ArrayList<Person> person = new ArrayList<>();

    // nhiệm vụ của constructor này là đọc dữ liệu file Json vào một Arraylist<Car>
    public PersonRepository() {
        try {
            File file = ResourceUtils.getFile("classpath:static/person.json");
            ObjectMapper mapper = new ObjectMapper();
            person.addAll(mapper.readValue(file, new TypeReference<List<Person>>() {
            }));
            person.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Person> getAllPerson() {
        return person;
    }
}
