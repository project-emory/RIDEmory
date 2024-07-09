package com.projectpandas.ridemory.ride;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 * Location class for ride locations, alongside some hardcoded locations.
 */
public class Location {
    // campus
    public static final Location NORTH_PARKWAY = new Location(new GeoJsonPoint(33.641562, -84.444563), "North Parkway");
    public static final Location SOUTH_PARKWAY = new Location(new GeoJsonPoint(33.640062, -84.444063), "South Parkway");
    public static final Location RIDESHARE = new Location(new GeoJsonPoint(33.642562, -84.444187), "Rideshare Lot");
    public static final Location RAOUL_CIRCLE = new Location(new GeoJsonPoint(33.794812, -84.324562), "Raoul Circle");
    public static final Location AMUC = new Location(new GeoJsonPoint(33.793813, -84.322563), "AMUC Circle");
    public static final Location COMPLEX = new Location(new GeoJsonPoint(33.790437, -84.321438), "Complex Hall");
    public static final Location HARRIS = new Location(new GeoJsonPoint(33.791313, -84.321188), "Harris Hall");
    public static final Location DICKEY = new Location(new GeoJsonPoint(33.792187, -84.325187), "Dickey Drive");
    public static final Location DOOLEY = new Location(new GeoJsonPoint(33.797062, -84.310312), "Dooley Drive");
    public static final Location STARVINE = new Location(new GeoJsonPoint(33.796312, -84.308688),
            "Starvine Parking Deck");

    // other
    public static final Location ATL = new Location(new GeoJsonPoint(33.640411, -84.419853),
            "Hartsfield-Jackson Atlanta International Airport");
    public static final Location ATL_INTL = new Location(new GeoJsonPoint(33.640563, -84.418188),
            "Hartsfield-Jackson Atlanta International Airport International Terminal");

    public static final Location[] values = {NORTH_PARKWAY, SOUTH_PARKWAY, RIDESHARE, RAOUL_CIRCLE, AMUC, COMPLEX,
            HARRIS, DICKEY, DOOLEY, STARVINE, ATL, ATL_INTL};

    private final GeoJsonPoint point;
    /** If null, Location is not predefined. */
    private final String name;

    private Location(GeoJsonPoint point, String name) {
        this.point = point;
        this.name = name;
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

    public String getName() {
        return name;
    }

    /**
     * Perhaps not the most elegant, but if fromPoint() returns null, the location
     * can be fetched via Google Maps API
     *
     * @param point
     *        point to get location from
     * @return location of point
     */
    public static Location fromPoint(GeoJsonPoint point) {
        for (Location loc : Location.values) {
            if (loc.getPoint().equals(point)) {
                return loc;
            }
        }
        return new Location(point, null);
    }
}
