package com.projectpandas.ridemory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpandas.ridemory.models.Ride;
import com.projectpandas.ridemory.repositories.RidesRepository;

@Service
public class RidesService {
    @Autowired
    RidesRepository rides;

    @Autowired
    RidesRepository repo;

    // CREATE
    public Ride createRide(Ride ride) {
        ride = rides.save(ride);
        return ride;
    }

    // READ
    public List<Ride> getRides() {
        return rides.listRides(0, 10);
    }

    public Ride getRide(String id) {
        return rides.findById(id).orElse(null);
    }

    // UPDATE
    public Ride addRider(String id) {
        Ride ride = rides.findById(id).orElse(null);
        if (ride != null) {
            ride.addRider();
            rides.save(ride);
        }
        return ride;
    }

    // DELETE
    public Ride deleteRide(String id) {
        return rides.deleteRideById(id);
    }

    // SEARCH
    public List<Ride> searchRides(long departTime, int riders) {
        long lowerBoundDepartTime = departTime - 3600000; // 1 hour in milliseconds
        long upperBoundDepartTime = departTime + 3600000;
        int riderOccupancy = 5 - riders;

        return rides.getRidesByFilter(lowerBoundDepartTime, upperBoundDepartTime, riderOccupancy);
    }
}
