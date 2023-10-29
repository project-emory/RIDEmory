package com.projectpandas.ridemory.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    // may need location id later on?
    private final String name;
    private String lat;
    private String lng;

    public Location() {
        name = "test";
    }

    public Location(String name) {
        this.name = name;
    }

    public Location(String name,
            String lat,
            String lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return String.format(
                "{\"name\": \"%s\", \"lat\": \"%s\", \"lng\": \"%s\"}",
                name, lat, lng);
    }
}
