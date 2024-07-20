package com.projectpandas.ridemory.ride;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends MongoRepository<Ride, ObjectId> {
    // https://stackoverflow.com/questions/71887036/use-limit-and-skip-in-mongorepositorycustomer-string
    @Aggregation("{'$skip':?0} {'$limit':?1}")
    public List<Ride> listRides(int skip, int limit);

    public Ride deleteRideById(String id);

    /**
     * Searches for all rides by the specified filters. Difficult to explain, so
     * refer to MongoDB's docs and your favorite LLM for more details; pipeline
     * filters by from location, to location, how full a ride is, and finally by
     * time. Since `$geoWithin` is in radians, radius needs to be divided by the
     * radius of the earth in meters. For future maintainers: Look up SpEL. Thank me
     * later.
     *
     * @param fromPoint from
     * @param toPoint to
     * @param radius radius in meters
     * @param space minimum space on ride
     * @param time time to search
     * @param after if query should be for after the given time
     * @return list of rides matching search
     */
    @Aggregation(pipeline = {"""
            { $geoNear: {
                near: :#{#from},
                key: 'from',
                distanceField: 'distanceFrom',
                maxDistance: :#{#radius},
                spherical: true
            }}
            """, """
            { $match : {
                to: { $geoWithin: {
                    $centerSphere: [
                        :#{#to.getCoordinates()},
                        :#{#radius / 6371000}
                    ]
                }}
            }}
            """, """
            { $match : {
                $expr: { $lte: [
                    :#{#space},
                    { $subtract: [6, { $add: [{ $size: '$riders' }, 1] }] }
                ]}
            }}
            """, """
            { $match : {
                $expr: { $cond: {
                    if: :#{#after},
                    then: { $gte: ['$departTime', :#{#time}] },
                    else: { $lte: ['$departTime', :#{#time}] }
                }}
            }}
            """})
    public List<Ride> getRidesBy(@Param("from") GeoJsonPoint fromPoint, @Param("to") GeoJsonPoint toPoint,
            @Param("radius") double radius, @Param("space") int space, @Param("time") long time,
            @Param("after") boolean after);
}
