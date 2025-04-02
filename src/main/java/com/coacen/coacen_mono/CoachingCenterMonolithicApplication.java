package com.coacen.coacen_mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
public class CoachingCenterMonolithicApplication
{

	public static void main(String[] args) {
		SpringApplication.run(CoachingCenterMonolithicApplication.class, args);
	}

}
