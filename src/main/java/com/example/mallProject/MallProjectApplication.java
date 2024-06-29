package com.example.mallProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MallProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallProjectApplication.class, args);
	}

}
