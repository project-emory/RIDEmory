package com.projectpandas.ridemory.models;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public enum Locations {
    // On-campus
    RAOUL_CIRCLE(new GeoJsonPoint(33.794812, -84.324562), "Raoul Circle"),
    AMUC(new GeoJsonPoint(33.793813, -84.322563), "AMUC"),
    COMPLEX(new GeoJsonPoint(33.790437, -84.321438), "Complex Hall"),
    HARRIS(new GeoJsonPoint(33.791313, -84.321188), "Harris Hall"),
    DICKEY(new GeoJsonPoint(33.792187, -84.325187), "Dickey Drive"),
    DOOLEY(new GeoJsonPoint(33.797062, -84.310312), "Dooley Drive"),
    STARVINE(new GeoJsonPoint(33.796312, -84.308688), "Starvine Way"),

    // ATL Airport
    ATL_NORTH_PARKWAY(new GeoJsonPoint(33.641562, -84.444563), "ATL North Parkway"),
    ATL_SOUTH_PARKWAY(new GeoJsonPoint(33.640062, -84.444063), "ATL South Parkway"),
    ATL_DOM(new GeoJsonPoint(33.640956, -84.443697), "ATL Domestic Terminal"),
    ATL_INTL(new GeoJsonPoint(33.640563, -84.418188), "ATL International Terminal"),
    ATL_RIDESHARE(new GeoJsonPoint(33.642562, -84.444187), "ATL Rideshare"),

    // Malls
    HMART_DORAVILLE(new GeoJsonPoint(33.907894, -84.287603), "Hmart Doraville"),
    HMART_DULUTH(new GeoJsonPoint(33.969859, -84.142567), "Hmart Duluth"),
    WALLMART_DECATUR(new GeoJsonPoint(33.793024, -84.285047), "Wallmart Decatur"),

    // Other
    STATE_FARM_ARENA(new GeoJsonPoint(33.7575, -84.3963), "State Farm Arena"),
    COCA_COLA_ROXY(new GeoJsonPoint(33.89977, -84.436023), "Coca-Cola Roxy"),
    GEORGIA_AQUARIUM(new GeoJsonPoint(33.763543, -84.394380), "Georgia Aquarium");

    private final GeoJsonPoint point;
    private final String name;

    private Locations(GeoJsonPoint point, String name) {
        this.point = point;
        this.name = name;
    }

    public GeoJsonPoint getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return point.getX();
    }

    public double getLon() {
        return point.getY();
    }
}
