package com.example.lesson_04_0914_thymeleaf.controller;

import com.example.lesson_04_0914_thymeleaf.model.Person;
import com.example.lesson_04_0914_thymeleaf.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    private PersonRepo personRepo;
    @GetMapping("/listAll")
    public String getAll(Model model){
        model.addAttribute("people", personRepo.getPeople());
        return "listAll";
    }
    @GetMapping("/listAll/{id}")
    public String infor(@PathVariable("id") Integer id, Model model){
        Person person = personRepo.getPeople().get(id);
        model.addAttribute("person",person);
        return "infor";
    }
}
