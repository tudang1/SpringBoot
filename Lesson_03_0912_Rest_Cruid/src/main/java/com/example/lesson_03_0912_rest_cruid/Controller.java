package com.example.lesson_03_0912_rest_cruid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class Controller {
    private ConcurrentHashMap<String, Job> job;
    @Autowired
    private JobRepo jobRepo;
    @GetMapping()
    public ResponseEntity<List<Job>> getAllBook(){

        JobRepo personRepository = new JobRepo();
        ArrayList<JobRepo> arr = new ArrayList<>();
        return ResponseEntity.ok().body(jobRepo.getAllPerson());
    }
    @PostMapping
    public Job createNewJob(@RequestBody JobRequest jobRequest) {
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job(uuid, jobRequest.title(), jobRequest.description(), jobRequest.location(),jobRequest.min_salary()
                ,jobRequest.max_salary(), jobRequest.email_to());
        job.put(uuid, newJob);
        return newJob;
    }
    @GetMapping(value="/{id}")
    public Job getJobById(@PathVariable("id") String id) {
        return job.get(id);
    }

    @PutMapping(value="/{id}")
    public Job updateBookById(@PathVariable("id") String id, @RequestBody JobRequest jobRequest) {
        Job updateJob = new Job(id, jobRequest.title(), jobRequest.description(), jobRequest.location(),jobRequest.min_salary()
                ,jobRequest.max_salary(), jobRequest.email_to());
        //books.put(id, updateBook);
        job.replace(id, updateJob);
        return updateJob;
    }

    @DeleteMapping(value="/{id}")
    public Job deleteBookById(@PathVariable("id") String id) {
        Job removedJob = job.remove(id);
        return removedJob;
    }
}
