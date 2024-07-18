package com.projectpandas.ridemory.ride;

import lombok.Data;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.projectpandas.ridemory.user.User;
import com.projectpandas.ridemory.util.ObjectIdListSerializer;
import com.projectpandas.ridemory.util.ObjectIdSerializer;

import java.util.ArrayList;
import java.util.List;

@Document("rides")
@CompoundIndexes({@CompoundIndex(name = "location_idx", def = "{'from': '2dsphere', 'to': '2dsphere'}"),
        @CompoundIndex(name = "time_idx", def = "{'departTime': -1}")})
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
    @JsonSerialize(using = ObjectIdListSerializer.class)
    private List<ObjectId> riders;
    /** See {@link riders}' security note */
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId organizer;

    /** Default constructor for MongoDB */
    public Ride() {
        super();
    }

    public Ride(User organizer, Location to, Location from) {
        this.to = to.getPoint();
        this.from = from.getPoint();
        this.riders = new ArrayList<>();
        this.organizer = organizer.getId();
        this.departTime = System.currentTimeMillis() / 1000L;
    }

    public List<ObjectId> getRiders() {
        List<ObjectId> ridersCopy = new ArrayList<>(riders);
        if (organizer != null)
            ridersCopy.add(organizer);
        return ridersCopy;
    }

    public List<ObjectId> joinRide(User rider) {
        if (riders.contains(rider.getId())) {
            logger.warn("User {} tried to join {} twice", rider, this);
        } else {
            riders.add(rider.getId());
        }

        return getRiders();
    }

    public List<ObjectId> leaveRide(User rider) {
        if (!riders.remove(rider.getId())) {
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
