import org.junit.Test;
import org.tp0.implementations.QueueOfQueue;
import org.tp0.implementations.StaticQueue;
import org.tp0.models.IQueueOfQueue;


public class QueueOfQueueTest {

    @Test
    public void concatenateTest(){
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
}
