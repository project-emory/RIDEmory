package com.projectpandas.ridemory.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectpandas.ridemory.services.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    InfoService service;

    @GetMapping("/atl")
    public Map<String, Integer> getATLWaitTime() {
        return service.getATLWaitTime();
    }
}
