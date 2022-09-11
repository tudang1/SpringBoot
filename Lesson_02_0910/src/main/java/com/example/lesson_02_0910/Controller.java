package com.example.lesson_02_0910;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private PersonRepository personRepo;
    @GetMapping()
    public ResponseEntity<List<Person>> getAllBook(){
        PersonRepository personRepository = new PersonRepository();
        ArrayList<PersonRepository> arr = new ArrayList<>();
        return ResponseEntity.ok().body(personRepo.getAllPerson());
    }

    @GetMapping("/people")
    @ResponseBody
    public ResponseEntity<List<Person>> add2(@RequestParam("sort") String a, @RequestParam("direction") String b) {

        return Service.sort(a,b);
    }

    @GetMapping("/count")
    public ResponseEntity<List<Person>> count(){
        PersonRepository personRepository = new PersonRepository();
        ArrayList<Person> arr = new ArrayList<>();

        arr.stream().count();
        return arr.stream().count();

    }

}
