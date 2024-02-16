package com.projectpandas.ridemory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
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
    @SuppressWarnings("null")
    public Ride createRide(Ride ride) {
        ride = rides.save(ride);
        return ride;
    }

    // READ
    public List<Ride> getRides() {
        return rides.listRides(0, 10);
    }

    @SuppressWarnings("null")
    public Ride getRide(String id) {
        return rides.findById(id).orElse(null);
    }

    // UPDATE
    @SuppressWarnings("null")
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
    public List<Ride> searchRidesByLocation(int locationType, String locationString) {
        if (locationType == 0) {
            // from
            return rides.getRidesByFrom(locationString);
        } else {
            // to
            return rides.getRidesByTo(locationString);
        }
    }

    public List<Ride> searchRidesNearLocation(int locationType, GeoJsonPoint locationPoint) {
        double maxDistance = 200.0; // in meters

        if (locationType == 0) {
            // from
            return rides.getRidesNearUser(locationPoint, maxDistance);
        } else {
            // to
            return rides.getRidesNearDestination(locationPoint, maxDistance);
        }
    }

    public List<Ride> searchRides(long departTime, int riders, GeoJsonPoint userLocation, GeoJsonPoint destineLocation) {
        // time filter
        long lowerBoundDepartTime = departTime - 3600000; // 1 hour in milliseconds
        long upperBoundDepartTime = departTime + 3600000;

        // rider filter
        int riderOccupancy = 5 - riders;
        
        // location filter
        double maxDistanceDeparture = 200.0;
        double maxDistanceDestination = 200.0;

        return rides.getRidesByFilter(lowerBoundDepartTime, upperBoundDepartTime, riderOccupancy, userLocation, maxDistanceDeparture, destineLocation, maxDistanceDestination);
    }
}
