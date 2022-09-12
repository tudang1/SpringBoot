package com.example.lesson_02_0910;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
//    public static Map<String, Integer> countPeopleByNationality() {
//        HashMap<String, Integer> result = new HashMap<>();
//        for (Person person : person) {
//            if (result.get(person.getNationality()) == null) {
//                result.put(person.getNationality(), 1);
//            } else {
//                result.put(person.getNationality(), result.get(person.getNationality()) + 1);
//            }
//        }
//        return result;
//    }
    public static Map<String,Long> countPeopleNationality(){
        return person
                .stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()));
    }
}
