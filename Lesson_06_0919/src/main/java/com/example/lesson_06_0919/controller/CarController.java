package com.example.lesson_06_0919.controller;

import com.example.lesson_06_0919.mapper.CarMapper;
import com.example.lesson_06_0919.model.Car;
import com.example.lesson_06_0919.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarRepository repo;
    @GetMapping()
    public String home(){
        return "index";
    }

    @GetMapping("/listAll")
    public String getAll(Model model, @RequestParam(value = "direction",required = false)String direction){
        if(direction==null){
            model.addAttribute("customers",repo.getAllCar());
        }else{
            List<Car> customers = repo.sort(direction);
            model.addAttribute("customers",customers);
        }
        return "list";
    }
    @GetMapping("/search")
    public String search(HttpServletRequest request, Model model){
        String brand = request.getParameter("brand");
        if (brand == ""){
            model.addAttribute("customers",repo.getAllCar());
            return "redirect:/listAll";
        }else {
            model.addAttribute("customers",repo.findByName(brand));
            return "list";
        }
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Car());
        return "CarForm";
    }
    @PostMapping("/post")
    public String postInfor(@ModelAttribute("customer") Car customer, BindingResult result, Model model){
        if (!result.hasErrors()) {
            if(customer.getId()>0){
                repo.update(customer.getId(), CarMapper.INSTANCE.carToPojo(customer));
            }else{
                repo.save(CarMapper.INSTANCE.carToPojo(customer));

            }
            model.addAttribute("customers", repo.getAllCar());
            return "redirect:/listAll";
        }
        return "CustomerForm";
    }
}
