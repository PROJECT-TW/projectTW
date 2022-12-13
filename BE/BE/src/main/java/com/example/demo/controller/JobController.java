package com.example.demo.controller;

import com.example.demo.dtos.JobDto;
import com.example.demo.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping(value = "/allJobs")
    public List<JobDto> getAllJobs() {

        return jobService.getAllJobs();
    }

    @PostMapping(value = "/addJob")
    public ResponseEntity<JobDto> addJob(@RequestBody JobDto jobDto) {
        JobDto addedJobDto = JobService.addJob(jobDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedJobDto);
    }

    
}
