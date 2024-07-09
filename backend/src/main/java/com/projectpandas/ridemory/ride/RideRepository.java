package com.projectpandas.ridemory.ride;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends MongoRepository<Ride, ObjectId> {
    // https://stackoverflow.com/questions/71887036/use-limit-and-skip-in-mongorepositorycustomer-string
    @Aggregation("{'$skip':?0} {'$limit':?1}")
    public List<Ride> listRides(int skip, int limit);

    public Ride deleteRideById(String id);

    // QUERY METHODS
    @Query("{ 'fromString': ?0 }")
    public List<Ride> getRidesByFrom(String fromString);

    @Query("{ 'toString': ?0 }")
    public List<Ride> getRidesByTo(String toString);

    @Query("{ 'from': { $near: { $geometry: ?0, $maxDistance: ?1 } } }")
    public List<Ride> getRidesNearUser(GeoJsonPoint userLocation, double maxDistance);

    @Query("{ 'to': { $near: { $geometry: ?0, $maxDistance: ?1 } } }")
    public List<Ride> getRidesNearDestination(GeoJsonPoint destineLocation, double maxDistance);

    @Query("""
            {\
                'departTime': { $gte: ?0, $lte: ?1 },\
                'riders': { $gte: ?2 },\
                'from': { $near: { $geometry: ?3, $maxDistance: ?4 } },\
                'to': { $near: { $geometry: ?5, $maxDistance: ?6 } }\
            }\
            """)
    public List<Ride> getRidesByFilter(long lowerBoundDepartTime, long upperBoundDepartTime, int riders,
            GeoJsonPoint userLocation, double maxDistanceDeparture, GeoJsonPoint destinLocation,
            double maxDistanceArrival);
}
