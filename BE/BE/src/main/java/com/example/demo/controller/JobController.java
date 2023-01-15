package com.example.demo.controller;

import com.example.demo.dtos.JobDto;
import com.example.demo.dtos.SearcherDto;
import com.example.demo.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping(value = "/allJobs")
    @CrossOrigin("192.168.1.254:4200")
    public List<JobDto> getAllJobs() {

        return jobService.getAllJobs();
    }

    @PostMapping(value = "/addJob")
   @CrossOrigin("192.168.1.254:4200")
    public ResponseEntity<JobDto> addJob(@RequestBody JobDto jobDto) {
        JobDto addedJobDto = JobService.addJob(jobDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedJobDto);
    }

    @GetMapping(value = "/getRandomJobs/{location}")
    public List<JobDto> getRandomJobs(@PathVariable String location) {
        return jobService.getFourJobs(location);
    }

    @GetMapping(value = "/getJobById/{id}")
    public JobDto getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }
}
