package com.projectpandas.ridemory.ride;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/rides")
public class RideController {
    @Autowired
    RideService rideService;

    /**
     * Create a ride.
     *
     * @param ride ride object to create
     * @return created ride
     */
    @PostMapping
    public ResponseEntity<Ride> createRide(@RequestBody Ride ride) {
        Ride result = rideService.createRide(ride);
        return result == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(result);
    }

    /**
     * Search for rides matching the given filters.
     *
     * @param from starting location in lat,lng format
     * @param to destination location in lat,lng format
     * @param radius search radius in meters
     * @param space minimum number of available seats
     * @param time time of departure in unix epoch time
     * @param after true if time is after, false if before
     * @return list of rides matching filters
     */
    @GetMapping
    public ResponseEntity<List<Ride>> searchRide(@RequestParam String from, @RequestParam String to,
            @RequestParam(required = false) Double radius, @RequestParam(required = false) Integer space,
            @RequestParam(required = false) Long time, @RequestParam(required = false) Boolean after) {
        List<Ride> rides = rideService.searchRides(from, to, radius, space, time, after);
        return rides == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(rides);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ride> getRide(@PathVariable String id) {
        Ride ride = rideService.getRide(new ObjectId(id));
        return ride == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(ride);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRide(@PathVariable String id) {
        Ride ride = rideService.deleteRide(id);
        return ride == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().build();
    }
}
