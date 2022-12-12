package com.example.demo.controller;

import com.example.demo.dtos.SearcherDto;
import com.example.demo.services.SearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class SearcherController {
    @Autowired
    SearcherService searcherService;

    @GetMapping(value = "/allSearchers")
    public List<SearcherDto> getAllSearchers() {

        return searcherService.getAllSearcher();
    }

    @PostMapping(value = "/addSearcher")
    public ResponseEntity<SearcherDto> addSearcher(@RequestBody SearcherDto searcherDto) {
        var x = searcherDto;
        SearcherDto addedSearcherDto = SearcherService.addSearcher(searcherDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedSearcherDto);
    }

    @GetMapping(value = "/getSearcherByEmail/{email}")
    @ResponseBody
    public SearcherDto getSearcherByEmail(@PathVariable String email) {
        return searcherService.getSearcherByEmail(email);
    }

    @GetMapping(value = "/getSearcherById/{id}")
    @ResponseBody
    public SearcherDto getSearcherById(@PathVariable Long id) {
        return searcherService.getSearcherById(id);
    }

}
