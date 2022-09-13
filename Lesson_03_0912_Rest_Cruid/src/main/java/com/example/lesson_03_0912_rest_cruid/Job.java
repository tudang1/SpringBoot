package com.example.lesson_03_0912_rest_cruid;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Job {
    private String id;
    private String title;
    private String description;
    private String location;
    private int min_salary;
    private int max_salary;
    private String email_to;

    public Job() {
    }

    public Job(String id, String title, String description, String location, int min_salary, int max_salary, String email_to) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
        this.email_to = email_to;
    }
}
