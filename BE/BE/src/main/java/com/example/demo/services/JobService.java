package com.example.demo.services;


import com.example.demo.dtos.JobDto;
import com.example.demo.entity.Job;
import com.example.demo.exceptions.CustomException;
import com.example.demo.mapper.JobMapper;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class JobService {
    @Autowired
    static JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<JobDto> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        List<JobDto> jobDtoList = JobMapper.toDtoList(jobs);
        return jobDtoList;
    }

    public static JobDto addJob(JobDto jobDto) {
        List<Job> jobs = jobRepository.findAll();
        List<JobDto> jobDtoList = JobMapper.toDtoList(jobs);
        Iterator<JobDto> iterator = jobDtoList.iterator();
        JobDto jobDtoInUse = new JobDto();
        while (iterator.hasNext()) {
            jobDtoInUse = iterator.next();
        }
        Job jobEntity = JobMapper.toEntity(jobDto);
        return JobMapper.toDto(jobRepository.save(jobEntity));
    }


}
