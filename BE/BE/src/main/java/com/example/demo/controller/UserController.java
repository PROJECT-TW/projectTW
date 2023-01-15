package com.example.demo.controller;

import com.example.demo.dtos.RecruiterDto;
import com.example.demo.dtos.SearcherDto;
import com.example.demo.dtos.SignUpFormDto;
import com.example.demo.dtos.UserDto;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.mapper.RecruiterMapper.signUpToRecruiterDto;
import static com.example.demo.mapper.SearcherMapper.signUpToSerarcherDto;

@RestController
public class UserController {

    //@Autowired
    //RecruiterService recruiterService;

   // @Autowired
   // SearcherService searcherService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/allRecruiters")
    public List<RecruiterDto> getAllRecruiters() {

        return userService.getAllRecruiters();
    }

    @PostMapping(value = "/addUser")
    @CrossOrigin("http://localhost:4200")
    public <T>  ResponseEntity<T> addUser(@RequestBody SignUpFormDto signUpFormDto) {
        if(signUpFormDto.getPassword().equals(signUpFormDto.getPassword2()))
        {
            if(signUpFormDto.getType()==true) {
                RecruiterDto  addRecruiterDto=signUpToRecruiterDto(signUpFormDto);
                RecruiterDto addedRecruiterDto = UserService.addRecruiter(addRecruiterDto);
                return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.CREATED).body(addedRecruiterDto);
            }
            else {
                SearcherDto addSearcherDto = signUpToSerarcherDto(signUpFormDto);
                SearcherDto addedSearcherDto = UserService.addSearcher(addSearcherDto);
                return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.CREATED).body(addedSearcherDto);
            }
        }
        else
            return null;
    }

    @PostMapping(value = "/login")
    //@CrossOrigin("http://localhost:4200")
    public <T> ResponseEntity<T> login(@RequestBody UserDto userL) {
            return ResponseEntity.status(HttpStatus.CREATED).body(UserService.login(userL));
    }

    @GetMapping(value = "/getRecruiterByEmail/{email}")
    public RecruiterDto getRecruiterByEmail(@PathVariable String email) {
        return userService.getRecruiterByEmail(email);
    }

    @GetMapping(value = "/allSearchers")
    @CrossOrigin(origins= {"*"}, maxAge = 48000, allowCredentials = "false")
    public List<SearcherDto> getAllSearchers() {

        return userService.getAllSearcher();
    }

    @GetMapping(value = "/getSearcherByEmail/{email}")
    public SearcherDto getSearcherByEmail(@PathVariable String email) {
        return userService.getSearcherByEmail(email);
    }

    @GetMapping(value = "/getSearcherById/{id}")
    public SearcherDto getSearcherById(@PathVariable Long id) {
        return userService.getSearcherById(id);
    }


}
