package com.example.crud_example_2.controller;

import com.example.crud_example_2.model.Category;
import com.example.crud_example_2.model.Product;
import com.example.crud_example_2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/listCategory")
    public String getAllJob(Model model){
        model.addAttribute("cats",categoryRepository.getCategories());
        return "listCategory";
    }

    //Job Form
    @GetMapping("/addCategory")
    public String addJob(Model model){
        model.addAttribute("cat",new Category());
        return "catForm";
    }

    //Them job
    @PostMapping("/addCategory")
    public String addJob(@Valid @ModelAttribute("cat")Category cat, BindingResult result, Model model){

        if(result.hasErrors()){
            return "catForm";
        }
        if (cat.getId() > 0) {
            categoryRepository.edit(cat);
            model.addAttribute("cats",categoryRepository.getCategories());
            return "listCategory";
        } else {
            Category newCat = categoryRepository.create(cat);
            if(newCat!=null){
                model.addAttribute("cats",categoryRepository.getCategories());
                return "listCategory";
            }
            model.addAttribute("error","Category already exist");
            return "catForm";
        }

    }

    //Cap nhat Job
    @GetMapping("/cat/edit/{id}")
    public String editJob(@PathVariable("id") int id, Model model) {
        Optional<Category> cat = categoryRepository.get(id);
        if (cat.isPresent()) {
            model.addAttribute("cat", cat.get());
        }
        return "catForm";
    }

    //Xoa job
    @GetMapping("/cat/delete/{id}")
    public String deleteJob(@PathVariable("id") int id, Model model) {
        categoryRepository.deleteById(id);
        model.addAttribute("cats", categoryRepository.getCategories());
        return "listCategory";
    }
}
