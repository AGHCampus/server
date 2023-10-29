package pl.edu.agh.server.service.common;

import lombok.Getter;

import java.io.Serializable;

public class Coordinate implements Serializable {
    @Getter
    private final double longitude;

    @Getter
    private final double latitude;

    public Coordinate(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
