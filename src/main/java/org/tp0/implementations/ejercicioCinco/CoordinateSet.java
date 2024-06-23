package org.tp0.implementations.ejercicioCinco;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CoordinateSet {
    public static Set<Coordinate> generateRandomCoordinates(int num) {
        Set<Coordinate> coordinates = new HashSet<>();
        Random rand = new Random();
        while (coordinates.size() < num) {
            double x = rand.nextDouble();
            double y = rand.nextDouble();
            coordinates.add(new Coordinate(x, y));
        }
        return coordinates;
    }
}
