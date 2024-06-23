import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;
import org.tp0.implementations.ejercicioCinco.Coordinate;
import org.tp0.implementations.ejercicioCinco.CoordinateSet;
import org.tp0.implementations.ejercicioCinco.MonteCarlo;

public class MonteCarloTest {
    @Test
    public void testApproximatePi() {
        MonteCarlo monteCarlo = new MonteCarlo();
        Set<Coordinate> randomCoordinates = CoordinateSet.generateRandomCoordinates(1000);

        for (Coordinate coordinate : randomCoordinates) {
            monteCarlo.addCoordinate(coordinate);
        }

        double piApproximation = monteCarlo.approximatePi();
        System.out.println("Approximated value of pi: " + piApproximation);
        
        assertEquals(Math.PI, piApproximation, 0.1);
    }
}
