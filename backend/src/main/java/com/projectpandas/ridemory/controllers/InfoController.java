package com.projectpandas.ridemory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projectpandas.ridemory.services.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    InfoService service;

    @GetMapping("/test")
    public String test() {
        try {
            return service.getTSAWaitTime().get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
