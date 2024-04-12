package com.projectpandas.ridemory.controllers;

import com.projectpandas.ridemory.models.Ride;
import com.projectpandas.ridemory.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/info")
public class InfoController {


    @Autowired
    InfoService service;

    @GetMapping("/")
    public boolean test() {
        return true;
    }

    @GetMapping("/atl")
    public Map<String, Integer> getATLWaitTime() {
        return service.getATLWaitTime();
    }
    @PostMapping("/duration")
    public String getTripDuration(@RequestBody Ride ride){
        return service.getTrafficTimeEstimate(ride);
//        return service.getTrafficaTimeEstimate(ride);
    }


}
