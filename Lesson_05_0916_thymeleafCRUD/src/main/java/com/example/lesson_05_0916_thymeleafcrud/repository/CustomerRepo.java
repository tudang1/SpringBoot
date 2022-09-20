package com.example.lesson_05_0916_thymeleafcrud.repository;

import com.example.lesson_05_0916_thymeleafcrud.mapper.CustomerMapper;
import com.example.lesson_05_0916_thymeleafcrud.model.Customer;
import com.example.lesson_05_0916_thymeleafcrud.model.CustomerPoJo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CustomerRepo {
    private List<Customer> customers = new ArrayList<>();
    public CustomerRepo(){
        customers.add(new Customer(1,"Dang Hong Tu","tu@gmail.com",123422));
        customers.add(new Customer(2,"Nguyen Huong A","huong@gmail.com",1222422));
        customers.add(new Customer(3,"Dang Bao L","bao@gmail.com",3123422));
    }
    public List<Customer> getAll(){
        return customers;
    }
    public Customer findById(Integer id){
        return customers.stream().filter(c->c.getId()==id).findFirst().orElse(null);
    }
    public Customer findByName(String name){
        return customers.stream().filter(c->c.getFullname().contains(name)).findAny().orElse(null);
    }
    public Customer findEmail(String email){
        return customers.stream().filter(c->c.getEmail().contains(email)).findAny().orElse(null);
    }
    public Customer update(Integer id, CustomerPoJo pojo){
        Customer updateCus = CustomerMapper.INSTANCE.pojoToCustomer(pojo);
        updateCus.setId(id);
        //tìm id để update
        customers = customers.stream().map(c->{
            if(c.getId()==id) return updateCus;
            else return c;}).collect(Collectors.toList());
        return updateCus;
    }
    public Customer save(CustomerPoJo pojo){
        Customer customer =CustomerMapper.INSTANCE.pojoToCustomer(pojo);
        // xac định phần tử cuối của list
        Customer lastCustomer = customers.get(customers.size() -1);
        //tạo thêm 1 phần tử nối tiếp
        var id =lastCustomer.getId() +1;
        customer.setId(id);
        customers.add(customer);
        return customer;
    }

    public Customer create(Customer customer){
        int id;
        if (customers.isEmpty()) {
            id = 1;
        } else {
            Customer lastCustomer = customers.get(customers.size() - 1);
            id = lastCustomer.getId() + 1;
        }
        customer.setId(id);
        customers.add(customer);
        return customer;
    }
    public Customer delete (Integer id){
        // tìm
        Optional<Customer> customer = customers.stream().filter(c->c.getId()==id).findFirst();
        if (customer.isPresent()){
            customers.remove(customer.get());
            return customer.get();
        }
        return null;
    }
    public List<Customer> sort(String direction){
        switch (direction){
            case "asc":
                return getAll()
                        .stream()
                        .sorted(Comparator.comparing(Customer::getFullname))
                        .collect(Collectors.toList());
            case "desc":
                return getAll().stream().sorted(Comparator.comparing(Customer::getFullname).reversed()).collect(Collectors.toList());
            default:
                return getAll();
        }
    }

}