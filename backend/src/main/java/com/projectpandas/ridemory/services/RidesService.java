package com.projectpandas.ridemory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpandas.ridemory.repositories.RidesRepository;

@Service
public class RidesService {
    @Autowired
    RidesRepository repo;
    
}
