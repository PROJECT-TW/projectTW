package com.example.demo.controller;

import com.example.demo.dtos.RecruiterDto;
import com.example.demo.dtos.SearcherDto;
import com.example.demo.dtos.SignUpFormDto;
import com.example.demo.dtos.UserDto;

import com.example.demo.entity.FileDb;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static com.example.demo.mapper.RecruiterMapper.signUpToRecruiterDto;
import static com.example.demo.mapper.SearcherMapper.signUpToSerarcherDto;

@RestController
public class UserController {


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
    @CrossOrigin("http://localhost:4200")
    public <T> ResponseEntity<T> login(@RequestBody UserDto userL) {
            return ResponseEntity.status(HttpStatus.CREATED).body(UserService.login(userL));
    }

    @GetMapping(value = "/getRecruiterByEmail/{email}")
    @CrossOrigin("http://localhost:4200")
    public RecruiterDto getRecruiterByEmail(@PathVariable String email) {
        return userService.getRecruiterByEmail(email);
    }

    @GetMapping(value = "/allSearchers")
    @CrossOrigin(origins= {"*"}, maxAge = 48000, allowCredentials = "false")
    public List<SearcherDto> getAllSearchers() {

        return userService.getAllSearcher();
    }

    @GetMapping(value = "/getSearcherByEmail/{email}")
    @CrossOrigin("http://localhost:4200")
    public SearcherDto getSearcherByEmail(@PathVariable String email) {
        return userService.getSearcherByEmail(email);
    }

    @GetMapping(value = "/getSearcherById/{id}")
    @CrossOrigin("http://localhost:4200")
    public SearcherDto getSearcherById(@PathVariable Long id) {
        return userService.getSearcherById(id);
    }

    @PutMapping(value = "/updateProfile")
    @CrossOrigin("http://localhost:4200")
    public <T> ResponseEntity<T> updateProfile(@RequestBody SignUpFormDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(UserService.updateUserData(userDto));
    }


    @PostMapping(value = "/uploadFile/{idUser}")
    @CrossOrigin("http://localhost:4200")
    public int uploadFile(@PathVariable Long idUser,@RequestBody MultipartFile file) throws IOException {
         if (UserService.uploadFile(idUser,file)!=null)
             return 1;
         else return 0;
    }

    @GetMapping(value = "/downloadFile/{idUser}")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long idUser) throws IOException {
        return UserService.downloadFile(idUser);
    }

    @GetMapping(value = "/getFileName/{idUser}")
    @CrossOrigin("http://localhost:4200")
    public FileDb getFileName(@PathVariable Long idUser) {
        return UserService.getFileName(idUser);
    }

}
