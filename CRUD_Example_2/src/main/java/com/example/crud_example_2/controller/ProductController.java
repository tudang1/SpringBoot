package com.example.crud_example_2.controller;

import com.example.crud_example_2.model.Product;
import com.example.crud_example_2.repository.ProductRepository;
import com.example.crud_example_2.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StorageService storageService;
    @GetMapping
    public String home(Model model){
        model.addAttribute("product",new Product());

        return "index";
    }
    @GetMapping("/listProduct")
    public String listProduct(Model model){
        model.addAttribute("products",productRepository.getProducts());
        return "listProduct";
    }
    @GetMapping("/listCategory")
    public String listCategory(Model model){
        model.addAttribute("categories",productRepository.getCategories());
        return "listCategory";
    }

    @GetMapping("/create")
    public String showFrom(Model model){
        model.addAttribute("product",new Product());
        return "showForm";
    }
    @PostMapping("/post")
    public String postInfo(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if(product.getId()>0){
                productRepository.edit(product);
            }else{
                productRepository.create(product);
            }
            storageService.uploadFile(product.getPhoto(), product.getId());
            model.addAttribute("products", productRepository.getProducts());
            return "redirect:/listProduct";
        }
        return "index";
    }
    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Optional<Product> product = productRepository.get(id);
        if(product.isPresent()){
            model.addAttribute("product",product.get());
        }
        return "index";
    }
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model){
        storageService.deleteFile(id);
        productRepository.deleteByID(id);

        model.addAttribute("product",productRepository.getProducts());
        return "redirect:/listProduct";
    }
    @GetMapping("/search")
    public String searchProduct(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        if(name==""){
            model.addAttribute("product",productRepository.getProducts());
            return "redirect:/listProduct";
        }
        else{
            Product product = productRepository.search(name);
            model.addAttribute("product",product);
            return "listProduct";
        }
    }
    @GetMapping("/searchCategory")
    public String searchCategory(HttpServletRequest request, Model model){
        String category = request.getParameter("category");
        if(category==""){
            model.addAttribute("product",productRepository.getProducts());
            return "redirect:/listProduct";
        }
        else{
            Product product = productRepository.searchByCategory(category);
            model.addAttribute("product",product);
            return "listProduct";
        }
    }

    @GetMapping("/listProduct/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        Product product = productRepository.get(id).get();
        model.addAttribute("product",product);
        return "detail";
    }
    @GetMapping("/listProduct/{category}")
    public String detail(@PathVariable("category") String category, Model model){
        Product product = (Product) productRepository.getCategories();
        model.addAttribute("product",product);
        return "detail";
    }



}
