package utils;

import java.util.TreeSet;

import org.tp0.implementations.ejercicioDos.StaticStack;
import org.tp0.models.Stack;

public class StackUtils {
        public static Stack removeDuplicatesAndSort(Stack stack) {
        TreeSet<Integer> sortedSet = new TreeSet<>();
        while (!stack.isEmpty()) {
            sortedSet.add(stack.getTop());
            stack.remove();
        }

        Stack newStack = new StaticStack();
        for (int elem : sortedSet) {
            newStack.add(elem);
        }

        return newStack;
    }

}
