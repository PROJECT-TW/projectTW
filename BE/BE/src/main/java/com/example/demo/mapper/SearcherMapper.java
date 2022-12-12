package com.example.demo.mapper;

import com.example.demo.dtos.SearcherDto;
import com.example.demo.entity.Searcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class SearcherMapper {
    public static Searcher toEntity(SearcherDto searcherDto){
        Searcher searcher=new Searcher();
        searcher.setEmail(searcherDto.getEmail());
        searcher.setId(searcherDto.getId());
        searcher.setFirstName(searcherDto.getFirstName());
        searcher.setLastName(searcherDto.getLastName());
        searcher.setPassword(searcherDto.getPassword());
        return searcher;
    }

    public static SearcherDto toDto(Searcher searcher){
        SearcherDto searcherDto=new SearcherDto();
        searcherDto.setEmail(searcher.getEmail());
        searcherDto.setId(searcher.getId());
        searcherDto.setFirstName(searcher.getFirstName());
        searcherDto.setLastName(searcher.getLastName());
        searcherDto.setPassword(searcher.getPassword());
        return searcherDto;
    }

    public static List<SearcherDto> toDtoList(List<Searcher> searcherList){
        List<SearcherDto> searcherDtoList=new ArrayList<>();
        Iterator<Searcher> it = searcherList.iterator();
        while(it.hasNext()){
            SearcherDto u=toDto(it.next());
            searcherDtoList.add(u);
        }
        return searcherDtoList;
    }

    public static List<Searcher> toEntityList(List<SearcherDto> searcherDtoList){
        List<Searcher> searcherList=new ArrayList<>();
        Iterator<SearcherDto> it = searcherDtoList.iterator();
        while(it.hasNext()){
            Searcher u=toEntity(it.next());
            searcherList.add(u);
        }
        return searcherList;
    }
}
