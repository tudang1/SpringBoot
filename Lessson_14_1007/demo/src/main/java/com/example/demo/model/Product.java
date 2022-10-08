package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    @Size(min=3,max=30,message = "Please input Name Product")
    private String name;
    @NotBlank(message = "Please enter the category")
    private String category;
    @NotBlank(message = "Detail not null")
    private String detail;
    @NotBlank(message = "Please input your photo")
    private MultipartFile photo;
}
