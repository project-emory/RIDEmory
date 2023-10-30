package com.projectpandas.ridemory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectpandas.ridemory.models.Ride;
import com.projectpandas.ridemory.repositories.RidesRepository;

@RestController
@RequestMapping
public class RidesController {

    // https://www.digitalocean.com/community/tutorials/spring-requestmapping-requestparam-pathvariable-example
    // see above for good quick-reference

    @Autowired
    RidesRepository rides;

    // CREATE

    // READ

    @GetMapping("/")
    public List<Ride> getRides() {
        return (rides.listRides(0, 10));
    }

    @GetMapping("/{id}")
    public Ride getRide(@PathVariable String id) {
        return rides.findById(id).orElse(null);
    }

    // UPDATE

    // DELETE
}
