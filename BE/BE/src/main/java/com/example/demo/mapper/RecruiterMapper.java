package com.example.demo.mapper;

import com.example.demo.dtos.RecruiterDto;
import com.example.demo.dtos.SignUpFormDto;
import com.example.demo.entity.Recruiter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Component
public class RecruiterMapper {
    public static Recruiter toEntity(RecruiterDto recruiterDto){
        Recruiter recruiter=new Recruiter();
        recruiter.setEmail(recruiterDto.getEmail());
        recruiter.setFirstName(recruiterDto.getFirstName());
        recruiter.setLastName(recruiterDto.getLastName());
        recruiter.setId(recruiterDto.getId());
        recruiter.setType(recruiterDto.getType());
        recruiter.setPassword(recruiterDto.getPassword());
        recruiter.setOrganization(recruiterDto.getOrganization());
        return recruiter;
    }

    public static RecruiterDto toDto(Recruiter recruiter){
        RecruiterDto recruiterDto=new RecruiterDto();
        recruiterDto.setEmail(recruiter.getEmail());
        recruiterDto.setId(recruiter.getId());
        recruiterDto.setType(recruiter.getType());
        recruiterDto.setFirstName(recruiter.getFirstName());
        recruiterDto.setLastName(recruiter.getLastName());
        recruiterDto.setPassword(recruiter.getPassword());
        recruiterDto.setOrganization(recruiter.getOrganization());
        return recruiterDto;
    }

    public static RecruiterDto signUpToRecruiterDto(SignUpFormDto signUpFormDto){
        RecruiterDto recruiterDto=new RecruiterDto();
        recruiterDto.setEmail(signUpFormDto.getEmail());
        recruiterDto.setId(signUpFormDto.getId());
        recruiterDto.setType(signUpFormDto.getType());
        recruiterDto.setFirstName(signUpFormDto.getFirstName());
        recruiterDto.setLastName(signUpFormDto.getLastName());
        recruiterDto.setPassword(signUpFormDto.getPassword());
        recruiterDto.setOrganization(signUpFormDto.getOrganization());
        return recruiterDto;
    }

    public static List<RecruiterDto> toDtoList(List<Recruiter> recruiterList){
        List<RecruiterDto> recruiterDtoList=new ArrayList<>();
        Iterator<Recruiter> it = recruiterList.iterator();
        while(it.hasNext()){
            RecruiterDto u=toDto(it.next());
            recruiterDtoList.add(u);
        }
        return recruiterDtoList;
    }

    public static List<Recruiter> toEntityList(List<RecruiterDto> recruiterDtoList){
        List<Recruiter> recruiterList=new ArrayList<>();
        Iterator<RecruiterDto> it = recruiterDtoList.iterator();
        while(it.hasNext()){
            Recruiter u=toEntity(it.next());
            recruiterList.add(u);
        }
        return recruiterList;
    }
}
