import org.junit.Test;
import org.tp0.implementations.StaticSet;
import org.tp0.implementations.StaticStack;
import org.tp0.models.Set;
import org.tp0.models.Stack;

import static org.tp0.implementations.StaticSet.copy;
import static org.tp0.implementations.StaticStack.reverseStack;

public class Ejercicio2 {

    @Test
    public void reverseStackTest() {

        Stack stack = new StaticStack();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        Stack stack1 = new StaticStack();
        stack1.add(3);
        stack1.add(2);
        stack1.add(1);

        System.out.printf("Stack con sus elementos invertidos \n");
        reverseStack(stack).print();

    }

    @Test
    public void copiarSet() {

        Set set = new StaticSet();
        set.add(1);
        set.add(2);
        set.add(3);
        Set copiaDelSet = copy(set);

    }
}
