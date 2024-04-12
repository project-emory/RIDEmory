package com.projectpandas.ridemory.models;

import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Data
public class Trip {
    private GeoJsonPoint origin;
    private GeoJsonPoint destination;

}
