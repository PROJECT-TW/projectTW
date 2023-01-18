package com.example.demo.services;

import com.example.demo.dtos.*;
import com.example.demo.entity.*;
import com.example.demo.exceptions.CustomException;
import com.example.demo.mapper.JobMapper;
import com.example.demo.mapper.RecruiterMapper;
import com.example.demo.mapper.SearcherMapper;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.example.demo.mapper.SearcherMapper.toDto;
import static com.example.demo.mapper.SearcherMapper.toEntity;

@Service
public class UserService {

    @Autowired
    static SearcherRepository searcherRepository;
    @Autowired
    static RecruiterRepository recruiterRepository;

    @Autowired
    static  FileDBRepository fileDBRepository;

    @Autowired
    static ApplicationRepository applicationRepository;

    @Autowired
    static FavoriteRepository favoriteRepository;

    @Autowired
    static JobRepository jobRepository;

    public UserService(SearcherRepository searcherRepository,RecruiterRepository recruiterRepository,FileDBRepository fileDBRepository ,ApplicationRepository applicationRepository,FavoriteRepository favoriteRepository,JobRepository jobRepository) {
        this.searcherRepository = searcherRepository;
        this.recruiterRepository = recruiterRepository;
        this.fileDBRepository=fileDBRepository;
        this.applicationRepository=applicationRepository;
        this.favoriteRepository=favoriteRepository;
        this.jobRepository = jobRepository;
    }

    public static <T> T  updateUserData(SignUpFormDto userDto) {
        if(getSearcherById(userDto.getId())!=null)
        {
            if((getSearcherById(userDto.getId())).getType()==false)
    {
        Searcher userFromDb = toEntity(getSearcherById(userDto.getId()));
        userFromDb.setPhone(userDto.getPhone());
        userFromDb.setOcupation(userDto.getOcupation());
        userFromDb.setLocation(userDto.getLocation());
        userFromDb.setFirstName(userDto.getFirstName());
        userFromDb.setLastName(userDto.getLastName());
        searcherRepository.save(userFromDb);
        return (T) SearcherMapper.toDto(searcherRepository.save(userFromDb));
    }} else
        if(getRecruiterById(userDto.getId())!=null)
        {if ((getRecruiterById(userDto.getId())).getType()==true) {
        Recruiter userFromDb = RecruiterMapper.toEntity(getRecruiterById(userDto.getId()));
        userFromDb.setPhone(userDto.getPhone());
        userFromDb.setOcupation(userDto.getOcupation());
        userFromDb.setFirstName(userDto.getFirstName());
        userFromDb.setLastName(userDto.getLastName());
        userFromDb.setOrganization(userDto.getOrganization());
            return (T) RecruiterMapper.toDto(recruiterRepository.save(userFromDb));
    }}
    return null;

    }

    private static RecruiterDto getRecruiterById(Long id) {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        List<RecruiterDto> recruiterDtoList = RecruiterMapper.toDtoList(recruiters);
        Iterator<RecruiterDto> iterator = recruiterDtoList.iterator();
        RecruiterDto recruitersDto = new RecruiterDto();
        while (iterator.hasNext()) {
            recruitersDto = iterator.next();
            if (recruitersDto.getId() == id) {
                return recruitersDto;
            }
        }
        return null;
    }

    public static Object uploadFile(Long idUser,MultipartFile file) throws IOException {
        var myFile = new FileDb(idUser,StringUtils.cleanPath(file.getOriginalFilename()),file.getContentType(),file.getBytes());
        return fileDBRepository.save(myFile);
    }

    public static ResponseEntity<Resource> downloadFile(Long idUser) throws IOException {
        List<FileDb> files = fileDBRepository.findAll();
        Iterator<FileDb> iterator = files.iterator();
        FileDb file = new FileDb();
        while (iterator.hasNext()) {
            file = iterator.next();
            if (file.getIdUser() == idUser) {
                break;
            }
        }
            FileDb attachment = file;
            return  ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(attachment.getType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + attachment.getName()
                                    + "\"")
                    .body(new ByteArrayResource(attachment.getData()));

    }

    public static FileDb getFileName(Long idUser) {
        List<FileDb> files = fileDBRepository.findAll();
        Iterator<FileDb> iterator = files.iterator();
        FileDb file = new FileDb();
        while (iterator.hasNext()) {
            file = iterator.next();
            if (file.getIdUser() == idUser) {
                return file;
            }
        }
        return null;
    }

    public static int deleteFile(Long idUser) {
        List<FileDb> files = fileDBRepository.findAll();
        Iterator<FileDb> iterator = files.iterator();
        FileDb file = new FileDb();
        while (iterator.hasNext()) {
            file = iterator.next();
            if (file.getIdUser() == idUser) {
                fileDBRepository.delete(file);
                return 1;
            }
        }
        return 0;
    }

    public static Application uploadApplication(Application application) {
        application.setApplicationDate(LocalDate.now());
        return applicationRepository.save(application);
    }

    public static Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public static List<Job> getFavoriteJobs(Long idUser) {
        List<Favorite> favoritesAll = favoriteRepository.findAll();
        List<Job> favoriteJobs=new ArrayList<>();
        Iterator<Favorite> iterator = favoritesAll.iterator();
        Favorite fav = new Favorite();
        while (iterator.hasNext()) {
            fav = iterator.next();
            if (fav.getIdUser()==idUser) {
                favoriteJobs.add(JobMapper.toEntity(JobService.getJobById(fav.getIdJob())));
        }
        }

        return favoriteJobs;
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

        Searcher searcherEntity = toEntity(searcherDto);
        return SearcherMapper.toDto(searcherRepository.save(searcherEntity));    }


    public SearcherDto getSearcherByEmail(String email) {
        return toDto(searcherRepository.findByEmail(email));
    }

    public static SearcherDto getSearcherById(Long id) {
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

    public List<RecruiterDto> getAllRecruiters() {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        List<RecruiterDto> recruiterDtoList = RecruiterMapper.toDtoList(recruiters);
        return recruiterDtoList;
    }

    public static RecruiterDto addRecruiter(RecruiterDto recruiterDto) {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        List<RecruiterDto> recruiterDtoList = RecruiterMapper.toDtoList(recruiters);
        Iterator<RecruiterDto> iterator = recruiterDtoList.iterator();
        RecruiterDto recruiterDtoInUse = new RecruiterDto();
        while (iterator.hasNext()) {
            recruiterDtoInUse = iterator.next();
            if (recruiterDtoInUse.getEmail().equals(recruiterDto.getEmail())) {
                throw new CustomException(HttpStatus.EXPECTATION_FAILED, "This email address is already used");            }
        }
        Recruiter recruiterEntity = RecruiterMapper.toEntity(recruiterDto);
        return RecruiterMapper.toDto(recruiterRepository.save(recruiterEntity));
    }
    public static <T> T login(UserDto userDto) {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        List<RecruiterDto> recruiterDtoList = RecruiterMapper.toDtoList(recruiters);
        Iterator<RecruiterDto> iterator = recruiterDtoList.iterator();
        RecruiterDto recruiterDtoInUse = new RecruiterDto();
        while (iterator.hasNext()) {
            recruiterDtoInUse = iterator.next();
            if (recruiterDtoInUse.getEmail().equals(userDto.getEmail()) &&
                    recruiterDtoInUse.getPassword().equals(userDto.getPassword())) {
                Recruiter recruiterEntity = RecruiterMapper.toEntity(recruiterDtoInUse);
                return (T) RecruiterMapper.toDto(recruiterRepository.save(recruiterEntity));
            }
        }
        List<Searcher> searcher = searcherRepository.findAll();
        List<SearcherDto> searcherDtoList = SearcherMapper.toDtoList(searcher);
        Iterator<SearcherDto> iterator1 = searcherDtoList.iterator();
        SearcherDto searcherDtoInUse = new SearcherDto();
        while (iterator1.hasNext()) {
            searcherDtoInUse = iterator1.next();
            if (searcherDtoInUse.getEmail().equals(userDto.getEmail()) &&
                    searcherDtoInUse.getPassword().equals(userDto.getPassword())) {
                Searcher searcherEntity = toEntity(searcherDtoInUse);
                return (T) SearcherMapper.toDto(searcherRepository.save(searcherEntity));
            }
        }
        return null;
    }

    public RecruiterDto getRecruiterByEmail(String email) {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        List<RecruiterDto> recruiterDtoList = RecruiterMapper.toDtoList(recruiters);
        Iterator<RecruiterDto> iterator = recruiterDtoList.iterator();
        RecruiterDto recruiterDto = new RecruiterDto();
        while (iterator.hasNext()) {
            recruiterDto = iterator.next();
            if (recruiterDto.getEmail().equals(email)) {
                return recruiterDto;
            }
        }
        return null;
    }


}
