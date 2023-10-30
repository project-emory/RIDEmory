package com.projectpandas.ridemory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RidemoryApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// Any test code can go here for now
		// Useful for pre-run processes
	}

	public static void main(String[] args) {
		SpringApplication.run(RidemoryApplication.class, args);
	}

}
