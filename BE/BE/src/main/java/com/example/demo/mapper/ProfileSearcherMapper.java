package com.example.demo.mapper;

import com.example.demo.dtos.ProfileSearcherDto;
import com.example.demo.entity.ProfileSearcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ProfileSearcherMapper {
    public static ProfileSearcher toEntity(ProfileSearcherDto profileSearcherDto){
        ProfileSearcher profileSearcher=new ProfileSearcher();
        profileSearcher.setEmail(profileSearcherDto.getEmail());
        profileSearcher.setId(profileSearcherDto.getId());
        profileSearcher.setFirstName(profileSearcherDto.getFirstName());
        profileSearcher.setLastName(profileSearcherDto.getLastName());
        return profileSearcher;
    }

    public static ProfileSearcherDto toDto(ProfileSearcher profileSearcher){
        ProfileSearcherDto profileSearcherDto=new ProfileSearcherDto();
        profileSearcherDto.setEmail(profileSearcher.getEmail());
        profileSearcherDto.setId(profileSearcher.getId());
        profileSearcherDto.setFirstName(profileSearcher.getFirstName());
        profileSearcherDto.setLastName(profileSearcher.getLastName());
        return profileSearcherDto;
    }

    public static List<ProfileSearcherDto> toDtoList(List<ProfileSearcher> profileSearcherList){
        List<ProfileSearcherDto> profileSearcherDtoList=new ArrayList<>();
        Iterator<ProfileSearcher> it = profileSearcherList.iterator();
        while(it.hasNext()){
            ProfileSearcherDto u=toDto(it.next());
            profileSearcherDtoList.add(u);
        }
        return profileSearcherDtoList;
    }

    public static List<ProfileSearcher> toEntityList(List<ProfileSearcherDto> profileSearcherDtoList){
        List<ProfileSearcher> profileSearcherList=new ArrayList<>();
        Iterator<ProfileSearcherDto> it = profileSearcherDtoList.iterator();
        while(it.hasNext()){
            ProfileSearcher u=toEntity(it.next());
            profileSearcherList.add(u);
        }
        return profileSearcherList;
    }
}
