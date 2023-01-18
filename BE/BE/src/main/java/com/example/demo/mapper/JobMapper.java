package com.example.demo.mapper;


import com.example.demo.dtos.JobDto;
import com.example.demo.entity.Job;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class JobMapper {
    public static Job toEntity(JobDto jobDto){
        Job job=new Job();
        job.setDescription(jobDto.getDescription());
        job.setPostDate(jobDto.getPostDate());
        job.setTitle(jobDto.getTitle());
        job.setId(jobDto.getId());
        job.setLocation(jobDto.getLocation());
        job.setOwner(jobDto.getOwner());
        job.setRequirements(jobDto.getRequirements());
        return job;
    }

    public static JobDto toDto(Job job){
        JobDto jobDto=new JobDto();
        jobDto.setId(job.getId());
        jobDto.setDescription(job.getDescription());
        jobDto.setPostDate(job.getPostDate());
        jobDto.setTitle(job.getTitle());
        jobDto.setLocation(job.getLocation());
        jobDto.setOwner(job.getOwner());
        jobDto.setRequirements(job.getRequirements());
        return jobDto;
    }

    public static List<JobDto> toDtoList(List<Job> jobList){
        List<JobDto> jobDtoList=new ArrayList<>();
        Iterator<Job> it = jobList.iterator();
        while(it.hasNext()){
            JobDto u=toDto(it.next());
            jobDtoList.add(u);
        }
        return jobDtoList;
    }

    public static List<Job> toEntityList(List<JobDto> jobDtoList){
        List<Job> jobList=new ArrayList<>();
        Iterator<JobDto> it = jobDtoList.iterator();
        while(it.hasNext()){
            Job u=toEntity(it.next());
            jobList.add(u);
        }
        return jobList;
    }
}
