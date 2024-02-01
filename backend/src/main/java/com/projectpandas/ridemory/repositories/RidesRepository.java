package com.projectpandas.ridemory.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.projectpandas.ridemory.models.Ride;

public interface RidesRepository extends MongoRepository<Ride, String> {

    // https://stackoverflow.com/questions/71887036/use-limit-and-skip-in-mongorepositorycustomer-string
    @Aggregation("{'$skip':?0}, {'$limit':?1}")
    public List<Ride> listRides(int skip, int limit);

    public Ride deleteRideById(String id);

    @Query("{" +
            "   'departTime': { $gte: ?0, $lte: ?1 }," +
            "   'riders': { $gte: ?2 }," +
            "   'from': { $near: { $geometry: ?3, $maxDistance: ?4 } }," +
            "   'to': { $near: { $geometry: ?5, $maxDistance: ?6 } }" +
            "}")
    public List<Ride> getRidesByFilter(
        long lowerBoundDepartTime,
        long upperBoundDepartTime,

        int riders,

        GeoJsonPoint userLocation,
        double maxDistanceDeparture,
        GeoJsonPoint destinLocation,
        double maxDistanceArrival
    );
    
    

}
