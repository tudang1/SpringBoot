package com.example.lesson_03_0912_rest_cruid;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class JobRepo {
    private static ArrayList<Job> job = new ArrayList<>();
    public JobRepo() {
        try {
            File file = ResourceUtils.getFile("classpath:static/job.json");
            ObjectMapper mapper = new ObjectMapper();
            job.addAll(mapper.readValue(file, new TypeReference<List<Job>>() {}));
            job.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static List<Job> getAllPerson() {
        return job;
    }
}
