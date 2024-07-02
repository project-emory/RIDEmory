package com.projectpandas.ridemory.ride;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public enum Locations {
    // campus
    NORTH_PARKWAY(new GeoJsonPoint(33.641562, -84.444563)), SOUTH_PARKWAY(new GeoJsonPoint(33.640062, -84.444063)),
    RIDESHARE(new GeoJsonPoint(33.642562, -84.444187)), RAOUL_CIRCLE(new GeoJsonPoint(33.794812, -84.324562)),
    AMUC(new GeoJsonPoint(33.793813, -84.322563)), COMPLEX(new GeoJsonPoint(33.790437, -84.321438)),
    HARRIS(new GeoJsonPoint(33.791313, -84.321188)), DICKEY(new GeoJsonPoint(33.792187, -84.325187)),
    DOOLEY(new GeoJsonPoint(33.797062, -84.310312)), STARVINE(new GeoJsonPoint(33.796312, -84.308688)),

    // other
    ATL(new GeoJsonPoint(33.640411, -84.419853)), ATL_INTL(new GeoJsonPoint(33.640563, -84.418188));

    private final GeoJsonPoint point;

    private Locations(GeoJsonPoint point) {
        this.point = point;
    }

    public GeoJsonPoint getPoint() {
        return point;
    }

    public double getLat() {
        return point.getX();
    }

    public double getLon() {
        return point.getY();
    }
}
