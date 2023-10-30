package com.projectpandas.ridemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectpandas.ridemory.models.Ride;
import com.projectpandas.ridemory.repositories.RidesRepository;

@SpringBootApplication
public class RidemoryApplication implements CommandLineRunner {

	@Autowired
	RidesRepository rides;

	@Override
	public void run(String... args) throws Exception {
		// Any test code can go here for now
		// Useful for pre-run processes
		rides.save(new Ride()); // debugging
	}

	public static void main(String[] args) {
		SpringApplication.run(RidemoryApplication.class, args);
	}

}
