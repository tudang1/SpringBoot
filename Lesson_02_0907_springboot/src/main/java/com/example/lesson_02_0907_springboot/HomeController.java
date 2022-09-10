package com.example.lesson_02_0907_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
// "/home" cài dặt như kiểu gốc
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping(value = "/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Animal> arr(){
        ArrayList<Animal> arr = new ArrayList<>();
        arr.add(new Animal("dog","fox"));
        arr.add(new Animal("cat","queen"));
        return arr;
    }
    @Autowired
    private CarRepository carRepo;
    @GetMapping("/car")
    public ResponseEntity<List<Car>> getAllCar(){
        CarRepository carRepository = new CarRepository();
        ArrayList<CarRepository> arr = new ArrayList<>();


        return ResponseEntity.ok().body(carRepo.getAllCar());
    }



}
