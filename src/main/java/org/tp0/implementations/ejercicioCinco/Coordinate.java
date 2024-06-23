package org.tp0.implementations.ejercicioCinco;

public class Coordinate {
    private double x;
    private double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}
