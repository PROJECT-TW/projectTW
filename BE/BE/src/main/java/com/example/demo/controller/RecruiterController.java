package com.example.demo.controller;

import com.example.demo.dtos.RecruiterDto;
import com.example.demo.services.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RecruiterController {
    @Autowired
    RecruiterService recruiterService;

    @GetMapping(value = "/allRecruiters")
    @CrossOrigin("192.168.1.254:4200")
    public List<RecruiterDto> getAllRecruiters() {

        return recruiterService.getAllRecruiters();
    }

    @PostMapping(value = "/addRecruiter")
    @CrossOrigin("192.168.1.254:4200")
    public ResponseEntity<RecruiterDto> addRecruiter(@RequestBody RecruiterDto recruiterDto) {
        RecruiterDto addedRecruiterDto = RecruiterService.addRecruiter(recruiterDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRecruiterDto);
    }

//    @GetMapping(value = "/getUserById/{id}")
//    public UserDto getUserById(@PathVariable int id) {
//        return userService.getUserById(id);
//    }
//

    @GetMapping(value = "/getRecruiterByEmail/{email}")
    @CrossOrigin("192.168.1.254:4200")
    public RecruiterDto getRecruiterByEmail(@PathVariable String email) {
        return recruiterService.getRecruiterByEmail(email);
    }

}
