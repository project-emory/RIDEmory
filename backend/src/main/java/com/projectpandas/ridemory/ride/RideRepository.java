package com.projectpandas.ridemory.ride;

import org.bson.types.ObjectId;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
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

    /**
     * Currently broken, as method doesn't filter `to` location - research
     * aggregations? Requires radius in meters
     */
    @Query("""
            { $and: [
                { 'from': { $near: { $geometry: :#{#from}, $maxDistance: :#{#radius} } } },
                { $expr: { $lte: [
                    :#{#space},
                    { $subtract: [5, { $add: [{ $size: '$riders' }, 1] }] }
                ]}},
                { $expr: { $cond: {
                    if: :#{#after},
                    then: { $gte: ['$departTime', :#{#time}] },
                    else: { $lte: ['$departTime', :#{#time}] }
                }}}
            ]}
            """)
    public List<Ride> getRidesTest(@Param("from") GeoJsonPoint fromPoint, @Param("to") GeoJsonPoint toPoint,
            @Param("radius") double radius, @Param("space") int space, @Param("time") long time,
            @Param("after") boolean after);
}
