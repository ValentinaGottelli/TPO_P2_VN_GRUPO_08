import org.junit.Test;
import org.tp0.implementations.QueueOfQueue;
import org.tp0.implementations.StaticQueue;
import org.tp0.models.IQueueOfQueue;
import org.tp0.models.Queue;


public class QueueOfQueueTest {

    @Test
    public void concatenateTest() {
        StaticQueue queue = new StaticQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        QueueOfQueue queueOfQueue = new QueueOfQueue();
        queueOfQueue.addQueue(queue);

        IQueueOfQueue[] queues = new IQueueOfQueue[1];
        queues[0] = queueOfQueue;

        IQueueOfQueue queueOfQueue1 = queueOfQueue.concatenate(queues);

        queueOfQueue1.print();
    }

    @Test
    public void flatTest() {
        StaticQueue queue = new StaticQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        QueueOfQueue queueOfQueue = new QueueOfQueue();
        queueOfQueue.addQueue(queue);
        queueOfQueue.addQueue(queue);

        Queue queue1 = queueOfQueue.flat();

        queue1.printQueue();
    }

    @Test
    public void reverseWithDepthTest() {
        Queue queue = new StaticQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        Queue queue2 = new StaticQueue();
        queue2.add(4);
        queue2.add(5);
        queue2.add(6);

        IQueueOfQueue queueOfQueue = new QueueOfQueue();
        queueOfQueue.addQueue(queue);
        queueOfQueue.addQueue(queue2);

        IQueueOfQueue reversed = queueOfQueue.reverseWithDepth();

        reversed.print();
    }

}
