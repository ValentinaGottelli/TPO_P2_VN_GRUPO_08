import org.junit.Test;
import org.tp0.implementations.QueueOfStacks;
import org.tp0.implementations.StaticStack;
import org.tp0.models.Stack;

import static org.junit.Assert.assertEquals;
import static org.tp0.implementations.QueueOfStacks.*;

public class QueueOfStacksTest {

    public static QueueOfStacks ejemploQueue() {
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
    public void testTraza() {
        QueueOfStacks queueOfStacks = ejemploQueue();

        int expectedTraze = 4;
        assertEquals(calculoTraza(queueOfStacks), expectedTraze);
    }

    @Test
    public void testTraspuesta() {
        QueueOfStacks queueOfStacks = ejemploQueue();

        QueueOfStacks expectedTraze = new QueueOfStacks(3);
        QueueOfStacks actualTraze = traspuesta(queueOfStacks);


        Stack stack = new StaticStack(3);

        stack.add(1);
        stack.add(1);
        stack.add(1);

        Stack stack2 = new StaticStack(3);

        stack2.add(2);
        stack2.add(2);
        stack2.add(2);

        expectedTraze.addStack(stack);
        expectedTraze.addStack(stack);
        expectedTraze.addStack(stack2);

        expectedTraze.printMatrix();
        System.out.printf("\n");
        actualTraze.printMatrix();
    }

    @Test
    public void sumaMatricialTest(){
        QueueOfStacks queueOfStacks = ejemploQueue();

        QueueOfStacks expectedSum = new QueueOfStacks(3);
        QueueOfStacks actualSum = sumaMatricial(queueOfStacks,queueOfStacks);

        Stack stack = new StaticStack(3);
        stack.add(2);
        stack.add(2);
        stack.add(4);

        expectedSum.addStack(stack);
        expectedSum.addStack(stack);
        expectedSum.addStack(stack);

        expectedSum.printMatrix();
        System.out.printf("\n");
        actualSum.printMatrix();
    }
}
