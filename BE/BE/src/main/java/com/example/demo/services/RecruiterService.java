package com.example.demo.services;

import com.example.demo.dtos.RecruiterDto;
import com.example.demo.dtos.SearcherDto;
import com.example.demo.dtos.UserDto;
import com.example.demo.entity.Recruiter;
import com.example.demo.entity.Searcher;
import com.example.demo.exceptions.CustomException;
import com.example.demo.mapper.RecruiterMapper;
import com.example.demo.mapper.SearcherMapper;
import com.example.demo.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

import static com.example.demo.services.SearcherService.searcherRepository;

@Service
public class RecruiterService {
    @Autowired
    static RecruiterRepository recruiterRepository;

    public RecruiterService(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    public List<RecruiterDto> getAllRecruiters() {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        List<RecruiterDto> recruiterDtoList = RecruiterMapper.toDtoList(recruiters);
        return recruiterDtoList;
    }

    public static RecruiterDto addRecruiter(RecruiterDto recruiterDto) {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        List<RecruiterDto> recruiterDtoList = RecruiterMapper.toDtoList(recruiters);
        Iterator<RecruiterDto> iterator = recruiterDtoList.iterator();
        RecruiterDto recruiterDtoInUse = new RecruiterDto();
        while (iterator.hasNext()) {
            recruiterDtoInUse = iterator.next();
            if (recruiterDtoInUse.getEmail().equals(recruiterDto.getEmail())) {
                throw new CustomException(HttpStatus.EXPECTATION_FAILED, "This email address is already used");            }
//        if (recruiterDtoInUse.getPassword().equals(recruiterDto.getPassword2())) {
//            throw new CustomException(HttpStatus.EXPECTATION_FAILED, "Password1 is not equal to Password2");    }
          }
        Recruiter recruiterEntity = RecruiterMapper.toEntity(recruiterDto);
        return RecruiterMapper.toDto(recruiterRepository.save(recruiterEntity));
    }
    public static <T> T login(UserDto userDto) {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        List<RecruiterDto> recruiterDtoList = RecruiterMapper.toDtoList(recruiters);
        Iterator<RecruiterDto> iterator = recruiterDtoList.iterator();
        RecruiterDto recruiterDtoInUse = new RecruiterDto();
        while (iterator.hasNext()) {
            recruiterDtoInUse = iterator.next();
            if (recruiterDtoInUse.getEmail().equals(userDto.getEmail()) &&
                    recruiterDtoInUse.getPassword().equals(userDto.getPassword())) {
                Recruiter recruiterEntity = RecruiterMapper.toEntity(recruiterDtoInUse);
                return (T) RecruiterMapper.toDto(recruiterRepository.save(recruiterEntity));
                           }
        }
        List<Searcher> searcher = searcherRepository.findAll();
        List<SearcherDto> searcherDtoList = SearcherMapper.toDtoList(searcher);
        Iterator<SearcherDto> iterator1 = searcherDtoList.iterator();
        SearcherDto searcherDtoInUse = new SearcherDto();
        while (iterator1.hasNext()) {
            searcherDtoInUse = iterator1.next();
            if (searcherDtoInUse.getEmail().equals(userDto.getEmail()) &&
                    searcherDtoInUse.getPassword().equals(userDto.getPassword())) {
                Searcher searcherEntity = SearcherMapper.toEntity(searcherDtoInUse);
                return (T) SearcherMapper.toDto(searcherRepository.save(searcherEntity));
            }
        }
        return null;
    }
//
//    public UserDto getUserById(int id) {
//        List<User> users = userRepository.findAll();
//        List<UserDto> userDtoList = UserMapper.toDtoList(users);
//        Iterator<UserDto> iterator = userDtoList.iterator();
//        UserDto userDto = new UserDto();
//        while (iterator.hasNext()) {
//            userDto = iterator.next();
//            //System.out.println(id + " si " + userDto.getId());
//
//            if (userDto.getId() == (long) id) {
//                // System.out.println(id + " si " + userDto.getId());
//                return userDto;
//            }
//        }
//        return null;
//    }

    public RecruiterDto getRecruiterByEmail(String email) {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        List<RecruiterDto> recruiterDtoList = RecruiterMapper.toDtoList(recruiters);
        Iterator<RecruiterDto> iterator = recruiterDtoList.iterator();
        RecruiterDto recruiterDto = new RecruiterDto();
        while (iterator.hasNext()) {
            recruiterDto = iterator.next();
            if (recruiterDto.getEmail().equals(email)) {
                return recruiterDto;
            }
        }
        return null;
    }

}
