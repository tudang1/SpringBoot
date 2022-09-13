package com.example.lesson_03_0913_home_work.controller;

import com.example.lesson_03_0913_home_work.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerPOJO customerToPOJO(Customer customer);
    Customer pojoToCustomer(CustomerPOJO pojo);
}