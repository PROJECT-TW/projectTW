package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.RecruiterRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(BeApplication.class, args);

		RecruiterRepository recruiterRepository=configurableApplicationContext.getBean(RecruiterRepository.class);
Recruiter teacher=new Recruiter("email5","lastname","firstname","pass","organization");
		recruiterRepository.save(teacher);

	}

}
