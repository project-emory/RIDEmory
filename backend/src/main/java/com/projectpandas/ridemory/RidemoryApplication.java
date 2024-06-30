package com.projectpandas.ridemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import com.projectpandas.ridemory.ride.Ride;
import com.projectpandas.ridemory.ride.RideRepository;

import java.util.Random;

@SpringBootApplication
public class RidemoryApplication implements CommandLineRunner {

    @Autowired
    RideRepository rides;

    @Override
    public void run(String... args) throws Exception {
        // Any test code can go here for now
        // Useful for pre-run processes
        if (rides.count() == 0) {
            // Auto-populate with 100 rides randomly
            for (int i = 0; i < 100; i++) {
                Ride ride = generateRandomRide();
                rides.save(ride);
            }
        }
        rides.save(new Ride()); // debugging
    }

    private Ride generateRandomRide() {
        Random random = new Random();
        double latitudeFrom = -90 + random.nextDouble() * 180;
        double longitudeFrom = -180 + random.nextDouble() * 360;
        double latitudeTo = -90 + random.nextDouble() * 180;
        double longitudeTo = -180 + random.nextDouble() * 360;
        return new Ride("test" + random.nextInt(1000), "testMessage" + random.nextInt(1000),
                new GeoJsonPoint(latitudeFrom, longitudeFrom), new GeoJsonPoint(latitudeTo, longitudeTo));
    }

    public static void main(String[] args) {
        SpringApplication.run(RidemoryApplication.class, args);
    }

}
