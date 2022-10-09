package com.example.crud_example_2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private int id;
    @NotBlank(message = "category not null")
    private String name;
}
