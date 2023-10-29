package com.projectpandas.ridemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectpandas.ridemory.config.DatabaseProperties;
import com.projectpandas.ridemory.repository.RideRepository;

@SpringBootApplication
public class RidemoryApplication {

	@Autowired
	DatabaseProperties dbProperties;

	@Autowired
	RideRepository rides;

	public static void main(String[] args) {
		SpringApplication.run(RidemoryApplication.class, args);
	}

}
