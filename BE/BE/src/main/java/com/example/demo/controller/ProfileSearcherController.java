package com.example.demo.controller;

import com.example.demo.dtos.ProfileSearcherDto;
import com.example.demo.services.ProfileSearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ProfileSearcherController {
    @Autowired
    ProfileSearcherService profileSearcherService;

    @GetMapping(value = "/allProfileSearchers")
    @CrossOrigin("192.168.1.254:4200")
    public List<ProfileSearcherDto> getAllProfileSearchers() {

        return profileSearcherService.getAllProfileSearchers();
    }

    @PostMapping(value = "/addProfileSearcher")
    @CrossOrigin("192.168.1.254:4200")
    public ResponseEntity<ProfileSearcherDto> addProfileSearcher(@RequestBody ProfileSearcherDto profileSearcherDto) {
        ProfileSearcherDto addedProfileSearcherDto = ProfileSearcherService.addProfileSearcher(profileSearcherDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProfileSearcherDto);
    }

//    @GetMapping(value = "/getUserById/{id}")
//    public UserDto getUserById(@PathVariable int id) {
//        return userService.getUserById(id);
//    }
//

    @GetMapping(value = "/getProfileSearcherByEmail/{email}")
    @CrossOrigin("192.168.1.254:4200")
    public ProfileSearcherDto getProfileSearcherByEmail(@PathVariable String email) {
        return profileSearcherService.getProfileSearcherByEmail(email);
    }

}
