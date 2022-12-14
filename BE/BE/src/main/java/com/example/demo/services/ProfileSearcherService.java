package com.example.demo.services;

import com.example.demo.dtos.ProfileSearcherDto;
import com.example.demo.entity.ProfileSearcher;
import com.example.demo.exceptions.CustomException;
import com.example.demo.mapper.ProfileSearcherMapper;
import com.example.demo.repository.ProfileSearcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

import static com.example.demo.mapper.ProfileSearcherMapper.toDto;


@Service
public class ProfileSearcherService {
    @Autowired
    static ProfileSearcherRepository profileSearcherRepository;

    public ProfileSearcherService(ProfileSearcherRepository profileSearcherRepository) {
        this.profileSearcherRepository = profileSearcherRepository;
    }


    public List<ProfileSearcherDto> getAllProfileSearchers() {
        List<ProfileSearcher> profileSearchers = profileSearcherRepository.findAll();
        List<ProfileSearcherDto> profileSearcherDtoList = ProfileSearcherMapper.toDtoList(profileSearchers);
        return profileSearcherDtoList;
    }

    public static ProfileSearcherDto addProfileSearcher(ProfileSearcherDto profileSearcherDto) {
        List<ProfileSearcher> profileSearchers = profileSearcherRepository.findAll();
        List<ProfileSearcherDto> profileSearcherDtoList = ProfileSearcherMapper.toDtoList(profileSearchers);
        Iterator<ProfileSearcherDto> iterator = profileSearcherDtoList.iterator();
        ProfileSearcherDto profileSearcherDtoInUse = new ProfileSearcherDto();
        while (iterator.hasNext()) {
            profileSearcherDtoInUse = iterator.next();
            if (profileSearcherDtoInUse.getEmail().equals(profileSearcherDto.getEmail())) {
                throw new CustomException(HttpStatus.EXPECTATION_FAILED, "This email address is already used");
            }

        }

        ProfileSearcher profileSearcherEntity = ProfileSearcherMapper.toEntity(profileSearcherDto);
        return ProfileSearcherMapper.toDto(profileSearcherRepository.save(profileSearcherEntity));    }


    public ProfileSearcherDto getProfileSearcherByEmail(String email) {
        return ProfileSearcherMapper.toDto(profileSearcherRepository.findByEmail(email));
    }

    public ProfileSearcherDto getProfileSearcherById(Long id) {
        List<ProfileSearcher> profileSearchers = profileSearcherRepository.findAll();
        List<ProfileSearcherDto> profileSearcherDtoList = ProfileSearcherMapper.toDtoList(profileSearchers);
        Iterator<ProfileSearcherDto> iterator = profileSearcherDtoList.iterator();
        ProfileSearcherDto profileSearcherDto = new ProfileSearcherDto();
        while (iterator.hasNext()) {
            profileSearcherDto = iterator.next();
            if (profileSearcherDto.getId() == id) {
                return profileSearcherDto;
            }
        }
        return null;
    }
}
