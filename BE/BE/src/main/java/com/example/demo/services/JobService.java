package com.example.demo.services;


import com.example.demo.dtos.JobDto;
import com.example.demo.dtos.SearcherDto;
import com.example.demo.entity.Job;
import com.example.demo.entity.Searcher;
import com.example.demo.exceptions.CustomException;
import com.example.demo.mapper.JobMapper;
import com.example.demo.mapper.SearcherMapper;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
        jobDto.setPostDate(LocalDate.now());
        Job jobEntity = JobMapper.toEntity(jobDto);
        return JobMapper.toDto(jobRepository.save(jobEntity));
    }

    public JobDto getJobById(Long id) {
        List<Job> jobs = jobRepository.findAll();
        List<JobDto> jobDtoList = JobMapper.toDtoList(jobs);
        Iterator<JobDto> iterator = jobDtoList.iterator();
        JobDto jobDto = new JobDto();
        while (iterator.hasNext()) {
            jobDto = iterator.next();
            if (jobDto.getId() == id) {
                return jobDto;
            }
        }
        return null;
    }


    public List<JobDto> getFourJobs(String location) {
        List<Job> jobs = jobRepository.findAll();
        List<JobDto> jobDtoList = JobMapper.toDtoList(jobs);
        List<JobDto> jobDtoListWithLocation = new ArrayList<>();
        Iterator<JobDto> iterator = jobDtoList.iterator();
        JobDto jobDto = new JobDto();
        while (iterator.hasNext()) {
            jobDto = iterator.next();
            if (jobDto.getLocation().equals(location)) {
                jobDtoListWithLocation.add(jobDto);
            }
        }
        if(location.equals("zzzz") || jobDtoListWithLocation.size()==0)
            return pickNRandomElements(jobDtoList,4);
        else
            if(jobDtoListWithLocation.size()>4)
            return pickNRandomElements(jobDtoListWithLocation,4);
        else
            return pickNRandomElements(jobDtoListWithLocation,jobDtoListWithLocation.size());
    }

    public static <E> List<E> pickNRandomElements(List<E> list, int n, Random r) {
        int length = list.size();

        if (length < n) return null;

        //We don't need to shuffle the whole list
        for (int i = length - 1; i >= length - n; --i)
        {
            Collections.swap(list, i , r.nextInt(i + 1));
        }
        return list.subList(length - n, length);
    }

    public static <E> List<E> pickNRandomElements(List<E> list, int n) {
        return pickNRandomElements(list, n, ThreadLocalRandom.current());
    }

    public List<JobDto> getFilteredJobs(String name, String location) {
        List<Job> jobs = jobRepository.findAll();
        List<JobDto> jobDtoList = JobMapper.toDtoList(jobs);
        List<JobDto> jobDtoListWithLocation = new ArrayList<>();
        Iterator<JobDto> iterator = jobDtoList.iterator();
        JobDto jobDtos = new JobDto();
        while (iterator.hasNext()) {
            jobDtos = iterator.next();
            if (jobDtos.getLocation().equals(location) && searchForTitleInJob(jobDtos.getTitle(),jobDtos.getDescription(),name)==true) {
                jobDtoListWithLocation.add(jobDtos);
            }
        }
        Collections.sort(jobDtoListWithLocation, (o1, o2) -> o1.getPostDate().compareTo(o2.getPostDate()));
        return jobDtoListWithLocation;

    }

    public boolean searchForTitleInJob(String title, String description, String filter){
        title=title.toLowerCase();
        description=description.toLowerCase();
        filter=filter.toLowerCase();
        if(title.contains(filter) || description.contains(filter))
            return true;
        return false;
    }
}
