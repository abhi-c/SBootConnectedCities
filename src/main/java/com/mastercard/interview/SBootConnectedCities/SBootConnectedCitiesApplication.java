package com.mastercard.interview.SBootConnectedCities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class SBootConnectedCitiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBootConnectedCitiesApplication.class, args);
	}

}
