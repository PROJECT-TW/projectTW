package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.RecruiterRepository;
import com.example.demo.repository.SearcherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(BeApplication.class, args);

//		SearcherRepository recruiterRepository=configurableApplicationContext.getBean(SearcherRepository.class);
//Searcher teacher=new Searcher("email19","lastname","firstname","pass");
//		recruiterRepository.save(teacher);

	}

}
