import org.junit.Test;
import org.tp0.implementations.QueueOfStacks;
import org.tp0.implementations.StaticStack;
import org.tp0.models.Stack;

import static org.junit.Assert.assertEquals;
import static org.tp0.implementations.QueueOfStacks.calculoTraza;

public class QueueOfStacksTest {

    public static QueueOfStacks ejemploQueue(){
        Stack stack = new StaticStack(3);

        stack.add(1);
        stack.add(1);
        stack.add(2);

        QueueOfStacks queueOfStacks = new QueueOfStacks(3);

        queueOfStacks.addStack(stack);
        queueOfStacks.addStack(stack);
        queueOfStacks.addStack(stack);

        return queueOfStacks;
    }


    @Test
    public void testTraza(){
        QueueOfStacks queueOfStacks = ejemploQueue();

        int expectedTraze = 4;
        assertEquals(calculoTraza(queueOfStacks),expectedTraze);
    }
}
