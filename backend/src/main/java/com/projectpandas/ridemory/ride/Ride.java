package com.projectpandas.ridemory.ride;

import lombok.Data;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.projectpandas.ridemory.user.User;
import com.projectpandas.ridemory.util.ObjectIdSerializer;

import java.util.ArrayList;
import java.util.List;

@Document("rides")
@Data
public class Ride {
    private static final Logger logger = LoggerFactory.getLogger(Ride.class);

    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint to;
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint from;
    private long departTime;

    /**
     * Needs to be ignored or serialized to be just count/anonymized users for
     * security reasons, maybe add custom JsonSerializer that converts to anonymous
     * name. Does NOT include organizer
     */
    @JsonIgnore
    @DBRef
    private List<User> riders;
    /** See {@link riders}' security note */
    private User organizer;

    public Ride(User organizer, Location to, Location from) {
        this.to = to.getPoint();
        this.from = from.getPoint();
        this.riders = new ArrayList<>();
        this.organizer = organizer;
        this.departTime = System.currentTimeMillis() / 1000L;
    }

    public List<User> getRiders() {
        List<User> ridersCopy = new ArrayList<>(riders);
        ridersCopy.add(organizer);
        return ridersCopy;
    }

    public List<User> joinRide(User rider) {
        if (riders.contains(rider)) {
            logger.warn("User {} tried to join {} twice", rider, this);
        } else {
            riders.add(rider);
        }

        return getRiders();
    }

    public List<User> leaveRide(User rider) {
        if (!riders.remove(rider)) {
            logger.warn("User {} tried to leave {} but was not in it", rider, this);
        }

        return getRiders();
    }

    public Location getTo() {
        return Location.fromPoint(to);
    }

    public Location getFrom() {
        return Location.fromPoint(from);
    }

    @Override
    public String toString() {
        return "Ride-" + id.toHexString();
    }
}
