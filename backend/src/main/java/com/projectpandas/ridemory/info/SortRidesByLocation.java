package com.projectpandas.ridemory.info;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import lombok.Data;

@Data
public class SortRidesByLocation {
    private GeoJsonPoint to;
    private int count;
}
