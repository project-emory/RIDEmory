package com.projectpandas.ridemory.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.projectpandas.ridemory.models.Ride;

public interface RidesRepository extends MongoRepository<Ride, String> {

    // TODO: add queries

    // https://stackoverflow.com/questions/71887036/use-limit-and-skip-in-mongorepositorycustomer-string
    @Aggregation("{'$skip':?0}, {'$limit':?1}")
    public List<Ride> listRides(int skip, int limit);

    public Ride deleteRideById(String id);

    @Query("$or: [ { departTime : { $gte: ?0 - 900 }, { $lte: ?0 + 900 } }, { riders: { $lte: 5 - ?1 } } ]")
    public List<Ride> getRidesByFilter(long departTime, int riders);
}
