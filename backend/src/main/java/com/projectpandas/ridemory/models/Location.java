package com.projectpandas.ridemory.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    // may need location id later on?
    // also will need to replace with GeoJSON, see
    // https://www.mongodb.com/docs/manual/geospatial-queries/
    // https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/core/geo/GeoJsonPoint.html
    private String name;
    private double lat;
    private double lng;

    public Location() {
        name = "test";
        lat = 0;
        lng = 0;
    }

    public Location(String name) {
        this.name = name;
    }

    public Location(String name,
            double lat,
            double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return String.format(
                "{\"name\": \"%s\", \"lat\": %s, \"lng\": %s}",
                name, lat, lng);
    }

}
