package com.projectpandas.ridemory.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import com.projectpandas.ridemory.models.Locations;
import com.projectpandas.ridemory.models.Ride;
import com.projectpandas.ridemory.repositories.RidesRepository;

@Service
public class RidesService {
    @Autowired
    RidesRepository rides;

    // CREATE
    @SuppressWarnings("null")
    public Ride createRide(Ride ride) {
        ride = rides.save(ride);
        return ride;
    }

    // CREATE
    public void generateRides(int quantity) {
        Locations[] locations = Locations.values();
        int id = 1;

        rides.deleteAll();
        for (int i = 0; i < quantity; i++) {
            Locations from = locations[new Random().nextInt(locations.length)];
            Locations to = locations[new Random().nextInt(locations.length)];
            GeoJsonPoint fromPoint = new GeoJsonPoint(from.getLat(), from.getLon());
            GeoJsonPoint toPoint = new GeoJsonPoint(to.getLat(), to.getLon());
            String fromString = from.name();
            String toString = to.name();
            int riders = new Random().nextInt(4) + 1;

            Ride ride = new Ride(id + "", "test", toPoint, fromPoint, toString, fromString, riders);

            rides.save(ride);
            id++;
        }
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

    // UPDATE
    @SuppressWarnings("null")
    public Ride removeRider(String id) {
        Ride ride = rides.findById(id).orElse(null);
        if (ride != null) {
            ride.removeRider();
            rides.save(ride);
        }
        return ride;
    }

    // DELETE
    public Ride deleteRide(String id) {
        return rides.deleteRideById(id);
    }

    // DELETE
    public void deleteAll() {
        rides.deleteAll();
    }

    // SEARCH
    public List<Ride> searchRidesByLocation(int locationType, String locationString) {
        if (locationType == 0) { // from
            return rides.getRidesByFrom(locationString);
        } else { // to
            return rides.getRidesByTo(locationString);
        }
    }

    public List<Ride> searchRidesNearLocation(int locationType, GeoJsonPoint locationPoint) {
        double maxDistance = 200.0; // in meters

        if (locationType == 0) { // from
            return rides.getRidesNearUser(locationPoint, maxDistance);
        } else { // to
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
