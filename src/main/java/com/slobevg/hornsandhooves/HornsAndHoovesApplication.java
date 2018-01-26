package com.slobevg.hornsandhooves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class HornsAndHoovesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HornsAndHoovesApplication.class, args);
	}
}
