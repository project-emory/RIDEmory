package com.projectpandas.ridemory.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import lombok.Data;

@Document("rides")
@Data
public class Ride {

    @Id
    private String id;

    private String messageID;
    private int riders = 1;
    private long departTime;
    private String fromString;
    private String toString;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint to;
    
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint from;

    public Ride() {
        id = "test";
        messageID = "test";
        to = Locations.NORTH_PARKWAY.getPoint();
        from = Locations.ATL.getPoint();
        riders = 1;
        departTime = now();
    }

    public Ride(String id, String messageID) {
        this.id = id;
        this.messageID = messageID;
        riders = 1;
        departTime = now();
        to = Locations.NORTH_PARKWAY.getPoint();
        from = Locations.ATL.getPoint();
    }

    public Ride(String id,
            String messageID,
            GeoJsonPoint to,
            GeoJsonPoint from) {
        this.id = id;
        this.messageID = messageID;
        this.to = to;
        this.from = from;
        this.departTime = now();
    }

    public Ride(String id,
            String messageID,
            GeoJsonPoint to,
            GeoJsonPoint from,
            long departTime) {
        this.id = id;
        this.messageID = messageID;
        this.to = to;
        this.from = from;
        this.departTime = departTime;
    }

    public Ride(String id,
            String messageID,
            GeoJsonPoint to,
            GeoJsonPoint from,
            String toString,
            String fromString,
            int riders) {
        this.id = id;
        this.messageID = messageID;
        this.to = to;
        this.from = from;
        this.toString = toString;
        this.fromString = fromString;
        this.riders = riders;
        this.departTime = now();
    }

    /**
     * @return current unix epoch time
     */
    public static long now() {
        return System.currentTimeMillis() / 1000L; // get current unix epoch time
    }

    public void addRider() {
        riders++;
    }

    public List<Double> getTo() {
        return to.getCoordinates();
    }

    public List<Double> getFrom() {
        return from.getCoordinates();
    }

    @Override
    public String toString() {
        return String.format(
                "{\"id\": \"%s\", \"messageId\": \"%s\", \"to\": %s, \"from\": %s, \"riders\": %s, \"departTime\": %s}",
                id, messageID, to, from, riders, departTime);
    }

}
