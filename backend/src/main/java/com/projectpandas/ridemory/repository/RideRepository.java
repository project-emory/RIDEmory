package com.projectpandas.ridemory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectpandas.ridemory.models.Ride;

public interface RideRepository extends MongoRepository<Ride, String> {
    // TODO: add queries
}
