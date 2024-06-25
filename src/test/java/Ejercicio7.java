import org.junit.Test;
import org.tp0.implementations.ejercicioSiete.StaticPriorityQueue;

import static org.junit.Assert.assertArrayEquals;

public class Ejercicio7 {

    @Test
    public void updatePriorityTest() {
        StaticPriorityQueue actual = new StaticPriorityQueue();

        actual.add(1, 1);
        actual.add(2, 1);
        actual.add(3, 2);

        StaticPriorityQueue expected = new StaticPriorityQueue();

        expected.add(1, 1);
        expected.add(2, 3);
        expected.add(3, 2);

        actual.printQueue();
        System.out.print("\n");
        actual.updatePriority(2, 3);

        actual.printQueue();

        assertArrayEquals(actual.getPriorities(), expected.getPriorities());
        assertArrayEquals(actual.getValues(), expected.getValues());
    }
}
