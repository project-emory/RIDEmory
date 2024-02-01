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

    // https://www.digitalocean.com/community/tutorials/spring-requestmapping-requestparam-pathvariable-example
    // see above for good quick-reference
    // request parameters:
    // https://stackoverflow.com/questions/32201441/how-do-i-retrieve-query-parameters-in-a-spring-boot-controller

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
    @GetMapping("/search")
    public List<Ride> searchRides(
            @RequestParam("departTime") long departTime, 
            @RequestParam("riders") int riders,
            @RequestParam("userLocation") GeoJsonPoint userLocation,
            @RequestParam("destinLocation") GeoJsonPoint destinLocation
    ) {
        return service.searchRides(departTime, riders, userLocation, destinLocation);
    }

    // DELETEALL
    @DeleteMapping("/nuke")
    public void nuke() {
        rides.deleteAll();
    }
}
