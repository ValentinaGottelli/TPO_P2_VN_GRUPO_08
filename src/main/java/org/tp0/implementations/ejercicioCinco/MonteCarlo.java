package org.tp0.implementations.ejercicioCinco;

import java.util.ArrayList;
import java.util.List;

public class MonteCarlo {
    private List<Coordinate> coordinates;

    public MonteCarlo() {
        coordinates = new ArrayList<>();
    }

    public void addCoordinate(Coordinate coord) {
        // This is a simple way to check if the coordinate is inside the unit square
        // Sorry for being so lazy
        if (coord.getX() >= 0 && coord.getX() <= 1 && coord.getY() >= 0 && coord.getY() <= 1) {
            coordinates.add(coord);
        }
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public double approximatePi() {
        int insideCircle = 0;
        for (Coordinate coord : coordinates) {
            if (coord.distanceFromOrigin() <= 1) {
                insideCircle++;
            }
        }
        return (double) insideCircle / coordinates.size() * 4;
    }
}
