package com.example.lesson_04_0914_thymeleaf.controller;

import com.example.lesson_04_0914_thymeleaf.mapper.PersonMapper;
import com.example.lesson_04_0914_thymeleaf.model.Person;
import com.example.lesson_04_0914_thymeleaf.model.PersonPojo;
import com.example.lesson_04_0914_thymeleaf.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private PersonRepo personRepo;
    @GetMapping("/")
    public String getHome() {
        return "home";
    }
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
    @GetMapping("/create")
    public String createCustomer(Model model){
        model.addAttribute("customer",new Person());
        return "CustomerForm";
    }
    @PostMapping("/post")
    public String postInfo(@ModelAttribute("customer") Person person, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if(person.getId()>0){
                personRepo.update(person.getId(), (PersonPojo) PersonMapper.INSTANCE.personToPojo(person));
            }else{
                personRepo.save((PersonPojo) PersonMapper.INSTANCE.personToPojo(person));

            }
            model.addAttribute("customers", personRepo.getPeople());
            return "redirect:/listAll";
        }
        return "CustomerForm";
    }
    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        Person customer = personRepo.findById(id);
        model.addAttribute("customer",customer);
        return "CustomerForm";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model){
        personRepo.delete(id);
        model.addAttribute("customers",personRepo.getPeople());
        return "redirect:/listAll";
    }
}
