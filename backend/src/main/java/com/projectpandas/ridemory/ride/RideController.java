package com.projectpandas.ridemory.ride;

import com.projectpandas.ridemory.info.InfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rides")
public class RideController {
    @Autowired
    RideRepository rides;

    @Autowired
    RideService service;

    @Autowired
    InfoService info;

    // CREATE
    @PostMapping("/new")
    public Ride createRide(@RequestBody Ride ride) {
        return service.createRide(ride);
    }

    // CREATE
    @PostMapping("/generate")
    public List<Ride> generateRides(@RequestParam int quantity) {
        service.generateRides(quantity);
        return service.getRides();
    }

    // READ
    @GetMapping("/")
    public List<Ride> getRides() {
        return service.getRides();
    }

    @GetMapping("/atl")
    public Map<String, Integer> getATLWaitTime() {
        return info.getATLWaitTime();
    }

    @GetMapping("/{id}")
    public Ride getRide(@PathVariable String id) {
        return service.getRide(id);
    }

    // UPDATE
    @PutMapping("/{id}/addrider")
    public Ride addRider(@PathVariable String id) {
        return service.addRider(id);
    }

    // UPDATE
    @PutMapping("/{id}/removerider")
    public Ride removeRider(@PathVariable String id) {
        return service.removeRider(id);
    }

    // DELETE
    @DeleteMapping("/remove/{id}")
    public Ride deleteRide(@PathVariable String id) {
        return service.deleteRide(id);
    }

    // DELETE
    @DeleteMapping("/nuke")
    public void nuke() {
        service.deleteAll();
    }

    // SEARCH
    /**
     * Search rides by location
     *
     * @param locationType
     *        0 for "from", 1 for "to"
     * @param locationName
     *        name of the location
     *
     * @return list of rides
     */
    @GetMapping("/searchat")
    public List<Ride> searchAt(@RequestParam int locationType, @RequestParam String locationName) {
        return service.searchRidesByLocation(locationType, locationName);
    }

    /**
     * Search rides near a location
     *
     * @param locationType
     *        0 for "from", 1 for "to"
     * @param locationCoordinate
     *        coordinates of the location
     *
     * @return list of rides
     */
    @GetMapping("/searchnear")
    public List<Ride> searchNear(@RequestParam int locationType, @RequestParam String locationCoordinate) {
        GeoJsonPoint locationPoint = convertToPoint(locationCoordinate);

        return service.searchRidesNearLocation(locationType, locationPoint);
    }

    /**
     * Search rides
     *
     * @param departTime
     *        time of departure
     * @param riders
     *        number of riders
     * @param userCoordinate
     *        coordinates of the user
     * @param destineCoordinate
     *        coordinates of the destination
     *
     * @return list of rides
     */
    @GetMapping("/search")
    public List<Ride> search(@RequestParam long departTime, @RequestParam int riders,
            @RequestParam String userCoordinate, @RequestParam String destineCoordinate) {
        GeoJsonPoint userLocation = convertToPoint(userCoordinate);
        GeoJsonPoint destineLocation = convertToPoint(destineCoordinate);

        return service.searchRides(departTime, riders, userLocation, destineLocation);
    }

    /**
     * Convert a string to a GeoJsonPoint
     *
     * @param source
     *        string to convert
     *
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
