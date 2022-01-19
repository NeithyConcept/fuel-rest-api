package fr.killiandev.fuelapi.fuel.models;

import lombok.Getter;

@Getter
public class Point {

    private final double latitude;
    private final double longitude;

    public Point(double[] point) {
        this.latitude = point[0];
        this.longitude = point[1];
    }
}
