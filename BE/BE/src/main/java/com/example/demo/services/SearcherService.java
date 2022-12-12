package com.example.demo.services;

import com.example.demo.dtos.SearcherDto;
import com.example.demo.entity.Searcher;
import com.example.demo.exceptions.CustomException;
import com.example.demo.mapper.SearcherMapper;
import com.example.demo.repository.SearcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

import static com.example.demo.mapper.SearcherMapper.toDto;

@Service
public class SearcherService {
    @Autowired
    static SearcherRepository searcherRepository;

    public SearcherService(SearcherRepository searcherRepository) {
        this.searcherRepository = searcherRepository;
    }

    public List<SearcherDto> getAllSearcher() {
        List<Searcher> searchers = searcherRepository.findAll();
        List<SearcherDto> searcherDtoList = SearcherMapper.toDtoList(searchers);
        return searcherDtoList;
    }

    public static SearcherDto addSearcher(SearcherDto searcherDto) {
        List<Searcher> searchers = searcherRepository.findAll();
        List<SearcherDto> searcherDtoList = SearcherMapper.toDtoList(searchers);
        Iterator<SearcherDto> iterator = searcherDtoList.iterator();
        SearcherDto searcherDtoInUse = new SearcherDto();
        while (iterator.hasNext()) {
            searcherDtoInUse = iterator.next();
            if (searcherDtoInUse.getEmail().equals(searcherDto.getEmail())) {
                throw new CustomException(HttpStatus.EXPECTATION_FAILED, "This email address is already used");
            }
          
        }

        Searcher searcherEntity = SearcherMapper.toEntity(searcherDto);
        return SearcherMapper.toDto(searcherRepository.save(searcherEntity));    }


    public SearcherDto getSearcherByEmail(String email) {
        return toDto(searcherRepository.findByEmail(email));
    }

    public SearcherDto getSearcherById(Long id) {
        List<Searcher> searchers = searcherRepository.findAll();
        List<SearcherDto> searcherDtoList = SearcherMapper.toDtoList(searchers);
        Iterator<SearcherDto> iterator = searcherDtoList.iterator();
        SearcherDto searcherDto = new SearcherDto();
        while (iterator.hasNext()) {
            searcherDto = iterator.next();
            if (searcherDto.getId() == id) {
                return searcherDto;
            }
        }
        return null;
    }

}
