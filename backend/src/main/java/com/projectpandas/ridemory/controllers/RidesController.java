package com.projectpandas.ridemory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectpandas.ridemory.models.Ride;
import com.projectpandas.ridemory.repositories.RidesRepository;
import com.projectpandas.ridemory.services.RidesService;

@RestController
@RequestMapping("/rides")
public class RidesController {
    @Autowired
    RidesRepository rides;

    @Autowired
    RidesService service;

    // CREATE
    @PostMapping("/new")
    public Ride createRide(@RequestBody Ride ride) {
        return service.createRide(ride);
    }

    // READ
    @GetMapping("/")
    public List<Ride> getRides() {
        return service.getRides();
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

    // DELETE
    @DeleteMapping("/remove/{id}")
    public Ride deleteRide(@PathVariable String id) {
        return service.deleteRide(id);
    }

    // SEARCH
    /**
     * Search rides by location
     * @param   locationType    0 for "from", 1 for "to"
     * @param   locationName    name of the location
     * @return  list of rides
     */
    @GetMapping("/searchByLocation")
    public List<Ride> searchRidesByLocation(
            @RequestParam("locationType") int locationType,
            @RequestParam("locationName") String locationName
    ) {
        return service.searchRidesByLocation(locationType, locationName);
    }

    /**
     * Search rides near a location
     * @param   locationType        0 for "from", 1 for "to"
     * @param   locationCoordinate  coordinates of the location
     * @return  list of rides
     */
    @GetMapping("/searchNearLocation")
    public List<Ride> searchRidesNearLocation(
            @RequestParam("locationType") int locationType,
            @RequestParam("locationCoordinate") String locationCoordinate
    ) {
        GeoJsonPoint locationPoint = convertToPoint(locationCoordinate);

        return service.searchRidesNearLocation(locationType, locationPoint);
    }

    /**
     * Search rides
     * @param   departTime          time of departure
     * @param   riders              number of riders
     * @param   userCoordinate      coordinates of the user
     * @param   destineCoordinate   coordinates of the destination
     * @return  list of rides
     */
    @GetMapping("/search")
    public List<Ride> searchRides(
            @RequestParam("departTime") long departTime, 
            @RequestParam("riders") int riders,
            @RequestParam("userCoordinate") String userCoordinate,
            @RequestParam("destineCoordinate") String destineCoordinate
    ) {
        GeoJsonPoint userLocation = convertToPoint(userCoordinate);
        GeoJsonPoint destineLocation = convertToPoint(destineCoordinate);
            
        return service.searchRides(departTime, riders, userLocation, destineLocation);
    }

    // DELETEALL
    @DeleteMapping("/nuke")
    public void nuke() {
        rides.deleteAll();
    }

    /**
     * Convert a string to a GeoJsonPoint
     * @param   source  string to convert
     * @return  GeoJsonPoint
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
