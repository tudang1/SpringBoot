package com.example.lesson_03_0913_home_work.controller;

import com.example.lesson_03_0913_home_work.model.Customer;
import com.example.lesson_03_0913_home_work.repository.CusRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class APIController {
    private ConcurrentHashMap<Integer,Customer> customerCon;
    public APIController(){
        customerCon = new ConcurrentHashMap<>();
        customerCon.put(1,new Customer(1,"Đặng Hồng Tư","dangtu@gmail,com",123456));
        customerCon.put(2,new Customer(2,"Đặng Văn A","vana@gmail,com",222222));
        customerCon.put(3,new Customer(3,"Nguyễn Hương B","nguyenhuong@gmail,com",444444));
    }

    @GetMapping
    public List<Customer> getCustomers (){
        return customerCon.values().stream().toList();
    }
    @PostMapping(value="/{id}")
    public Customer createNewBook(@PathVariable("id") int id,@RequestBody CusRequest cusRequest) {
        Customer newCustomer = new Customer(id,cusRequest.fullname(),cusRequest.email(),cusRequest.telephone());
        customerCon.put(id, newCustomer);
        return newCustomer;
    }
    @GetMapping(value="/{id}")
    public Customer getCustomerById(@PathVariable("id") int id){
        return customerCon.get(id);
    }
    @PutMapping(value="/{id}")
    public Customer updateCusById(@PathVariable("id") int id,@RequestBody CusRequest cusRequest){
        Customer updateCustomer = new Customer(id,cusRequest.fullname(),cusRequest.email(),cusRequest.telephone());
        customerCon.replace(id,updateCustomer);
        return updateCustomer;
    }
    @DeleteMapping(value="/{id}")
    public Customer deleteCusById(@PathVariable("id") int id) {
        Customer removedCus = customerCon.remove(id);
        return removedCus;
    }

}
