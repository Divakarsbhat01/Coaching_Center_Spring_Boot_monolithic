package com.coacen.coacen_mono;

import com.coacen.coacen_mono.Entity.User_Details;
import com.coacen.coacen_mono.Repository.User_Credentials_Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
public class CoachingCenterMonolithicApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachingCenterMonolithicApplication.class, args);
	}

}
