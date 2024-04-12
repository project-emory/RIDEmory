package com.projectpandas.ridemory.util;

import com.projectpandas.ridemory.models.Ride;
import com.projectpandas.ridemory.repositories.RidesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RandomDataGenerator {

    @Autowired
    RidesRepository rides;
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//        // This method will be invoked when the application is fully started
//        // Generate random data here
//        // Example:
//         generateRandomData();
//    }
//
    @EventListener(ApplicationReadyEvent.class)
    private void generateRandomData() {
        // Generate random data logic
        List<Ride> allRides = rides.findAll();
        if (allRides.isEmpty()) {
            // Auto-populate with 100 rides randomly
            for (int i = 0; i < 100; i++) {
                Ride ride = generateRandomRide();
                rides.save(ride);
            }
        }
    }
    private Ride generateRandomRide() {
        Random random = new Random();
        double latitudeFrom = -90 + random.nextDouble() * 180;
        double longitudeFrom = -180 + random.nextDouble() * 360;
        double latitudeTo = -90 + random.nextDouble() * 180;
        double longitudeTo = -180 + random.nextDouble() * 360;
        return new Ride(
                "test" + random.nextInt(1000),
                "testMessage" + random.nextInt(1000),
                new GeoJsonPoint(latitudeFrom,longitudeFrom),
                new GeoJsonPoint(latitudeTo, longitudeTo)
        );
    }
}
