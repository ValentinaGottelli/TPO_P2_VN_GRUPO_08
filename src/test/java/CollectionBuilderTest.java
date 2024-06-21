import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.tp0.implementations.CollectionBuilder;
import org.tp0.implementations.StaticSet;
import org.tp0.implementations.StaticStack;
import org.tp0.models.Set;
import org.tp0.models.Stack;

public class CollectionBuilderTest {

    @Test
    public void testAddToSet() {
        CollectionBuilder<Set> setBuilder = new CollectionBuilder<>(new StaticSet());
        Set set = setBuilder.add(1).add(2).add(3).build();

        int[] expectedElements = {1, 2, 3};
        int randomElement = set.choose();
        
        assertTrue(Arrays.stream(expectedElements).anyMatch(e -> e == randomElement));
    }

    @Test
    public void testAddAllToSet() {
        CollectionBuilder<Set> setBuilder = new CollectionBuilder<>(new StaticSet());

        Set set2 = new StaticSet();
        set2.add(4);
        set2.add(5);

        setBuilder.addAll(set2);
        Set set3 = setBuilder.build();

        int[] expectedElements = {1, 2, 3, 4, 5};
        int randomElement = set3.choose();

        assertTrue(Arrays.stream(expectedElements).anyMatch(e -> e == randomElement));
    }

    @Test
    public void testAddToStack() {
        CollectionBuilder<Stack> stackBuilder = new CollectionBuilder<>(new StaticStack());
        Stack stack = stackBuilder.add(10).add(20).add(30).build();

        int[] expectedElements = {10, 20, 30};
        int topElement = stack.getTop();

        assertTrue(Arrays.stream(expectedElements).anyMatch(e -> e == topElement));
    }
}
