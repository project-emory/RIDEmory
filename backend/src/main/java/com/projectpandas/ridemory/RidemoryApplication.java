package com.projectpandas.ridemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectpandas.ridemory.ride.RideRepository;
import com.projectpandas.ridemory.ride.RideService;

@SpringBootApplication
public class RidemoryApplication implements CommandLineRunner {
    @Autowired
    RideRepository rideRepository;
    @Autowired
    RideService rideService;

    @Override
    public void run(String... args) throws Exception {
        // Any test code can go here for now
        // Useful for pre-run processes
        if (rideRepository.count() == 0) {
            // Auto-populate with 25 rides randomly
            rideService.generateRides(25);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(RidemoryApplication.class, args);
    }
}
