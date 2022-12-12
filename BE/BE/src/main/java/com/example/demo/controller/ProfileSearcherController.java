package com.example.demo.controller;

import com.example.demo.dtos.ProfileSearcherDto;
import com.example.demo.services.ProfileSearcherService;
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
public class ProfileSearcherController {
    @Autowired
    ProfileSearcherService profileSearcherService;

    @GetMapping(value = "/allProfileSearchers")
    public List<ProfileSearcherDto> getAllProfileSearchers() {

        return profileSearcherService.getAllProfileSearchers();
    }

    @PostMapping(value = "/addProfileSearcher")
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
    public ProfileSearcherDto getProfileSearcherByEmail(@PathVariable String email) {
        return profileSearcherService.getProfileSearcherByEmail(email);
    }

}
