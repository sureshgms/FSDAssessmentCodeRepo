package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
//@ComponentScan({"com.bean"})
//@ComponentScan(basePackages= {"com.controller"})
@EntityScan(basePackages = "com.bean")
@EnableJpaRepositories(basePackages = "com.repository")

public class SportyShoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesApplication.class, args);
		System.out.println("Server up and running at port 8080");
	}

}
