package com.projectpandas.ridemory.ride;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {
    @Autowired
    RideRepository rideRepository;
    @Autowired
    RideService rideService;

    /**
     * Create a ride
     *
     * @param ride ride object to create
     * @return created ride
     */
    @PostMapping("/")
    public ResponseEntity<Ride> createRide(@RequestBody Ride ride) {
        Ride result = rideService.createRide(ride);
        return result == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/")
    public ResponseEntity<List<Ride>> getRideRepository() {
        List<Ride> rides = rideService.getRides();
        return rides == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(rides);
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

    @PostMapping("/generate")
    public ResponseEntity<List<Ride>> generateRides(@RequestParam int quantity) {
        List<Ride> rides = rideService.generateRides(quantity);
        return rides == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(rides);
    }

    // TODO: combine search together into one method with query parameters
    // TODO: clean processing to be more elegant

    /**
     * Search rides by location
     *
     * @param locationType 0 for "from", 1 for "to"
     * @param locationName name of the location
     * @return list of rides
     */
    @GetMapping("/searchat")
    public ResponseEntity<List<Ride>> searchAt(@RequestParam int locationType, @RequestParam String locationName) {
        List<Ride> rides = rideService.searchRidesByLocation(locationType, locationName);
        return rides == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(rides);
    }

    /**
     * Search rides near a location
     *
     * @param locationType 0 for "from", 1 for "to"
     * @param locationCoordinate coordinates of the location
     * @return list of rides
     */
    @GetMapping("/searchnear")
    public ResponseEntity<List<Ride>> searchNear(@RequestParam int locationType,
            @RequestParam String locationCoordinate) {
        GeoJsonPoint locationPoint = convertToPoint(locationCoordinate);
        List<Ride> rides = rideService.searchRidesNearLocation(locationType, locationPoint);
        return rides == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(rides);
    }

    /**
     * Search rides
     *
     * @param departTime time of departure
     * @param riders number of riders
     * @param fromCoordinate coordinates of the user
     * @param toCoordinate coordinates of the destination
     * @return list of rides
     */
    @GetMapping("/search")
    public ResponseEntity<List<Ride>> search(@RequestParam long departTime, @RequestParam int riders,
            @RequestParam String fromCoordinate, @RequestParam String toCoordinate) {
        GeoJsonPoint from = convertToPoint(fromCoordinate);
        GeoJsonPoint to = convertToPoint(toCoordinate);
        List<Ride> rides = rideService.searchRides(departTime, riders, from, to);
        return rides == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(rides);
    }

    /**
     * Convert a string to a GeoJsonPoint
     *
     * @param source string to convert
     * @return GeoJsonPoint
     */
    private GeoJsonPoint convertToPoint(String source) {
        try {
            String[] coordinates = source.split(",");
            double lng = Double.parseDouble(coordinates[0].trim());
            double lat = Double.parseDouble(coordinates[1].trim());
            GeoJsonPoint point = new GeoJsonPoint(lng, lat);

            return point;
        } catch (Exception e) {
            // Handle conversion exception if needed
            throw new IllegalArgumentException("Invalid coordinates format: " + source, e);
        }
    }
}
