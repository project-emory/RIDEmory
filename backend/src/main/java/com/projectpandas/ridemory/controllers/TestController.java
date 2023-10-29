package com.projectpandas.ridemory.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectpandas.ridemory.models.Ride;

@RestController
public class TestController {

    @GetMapping("/")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/rides")
    public String getRides() {
        return "";
    }

    @PostMapping("/rides/new")
    public Ride createRide(@RequestBody Ride ride) {
        System.out.println(ride);
        return ride;
    }

}
