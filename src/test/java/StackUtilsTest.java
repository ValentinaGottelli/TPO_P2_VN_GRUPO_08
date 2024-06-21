import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;
import org.tp0.implementations.StaticStack;
import org.tp0.models.Stack;

import utils.StackUtils;

public class StackUtilsTest {

    @Test
    public void testRemoveDuplicatesAndSortWithDuplicates() {
        Stack stack = new StaticStack();
        stack.add(3);
        stack.add(1);
        stack.add(4);
        stack.add(2);
        stack.add(5);
        stack.add(3);
        stack.add(2);

        Stack newStack = StackUtils.removeDuplicatesAndSort(stack);

        int[] expectedElements = {1, 2, 3, 4, 5};
        int[] actualElements = Arrays.stream(newStack.getArray())
                                     .filter(value -> value != 0)
                                     .toArray();

        assertArrayEquals(expectedElements, actualElements);
    }

    @Test
    public void testRemoveDuplicatesAndSortWithoutDuplicates() {
        Stack stack = new StaticStack();
        stack.add(3);
        stack.add(1);
        stack.add(4);
        stack.add(2);
        stack.add(5);

        Stack newStack = StackUtils.removeDuplicatesAndSort(stack);

        int[] expectedElements = {1, 2, 3, 4, 5};
        int[] actualElements = Arrays.stream(newStack.getArray())
                                     .filter(value -> value != 0)
                                     .toArray();

        assertArrayEquals(expectedElements, actualElements);
    }

    @Test
    public void testRemoveDuplicatesAndSortEmptyStack() {
        Stack stack = new StaticStack();

        Stack newStack = StackUtils.removeDuplicatesAndSort(stack);

        int[] expectedElements = {};
        int[] actualElements = Arrays.stream(newStack.getArray())
                                     .filter(value -> value != 0)
                                     .toArray();

        assertArrayEquals(expectedElements, actualElements);
    }

    @Test
    public void testRemoveDuplicatesAndSortSingleElement() {
        Stack stack = new StaticStack();
        stack.add(1);

        Stack newStack = StackUtils.removeDuplicatesAndSort(stack);

        int[] expectedElements = {1};
        int[] actualElements = Arrays.stream(newStack.getArray())
                                     .filter(value -> value != 0)
                                     .toArray();

        assertArrayEquals(expectedElements, actualElements);
    }
}
