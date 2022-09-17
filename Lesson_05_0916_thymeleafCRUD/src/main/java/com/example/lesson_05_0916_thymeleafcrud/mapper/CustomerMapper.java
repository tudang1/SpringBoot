package com.example.lesson_05_0916_thymeleafcrud.mapper;

import com.example.lesson_05_0916_thymeleafcrud.model.Customer;
import com.example.lesson_05_0916_thymeleafcrud.model.CustomerPoJo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerPoJo customerToPojo(Customer customer);
    Customer pojoToCustomer(CustomerPoJo poJo);
}