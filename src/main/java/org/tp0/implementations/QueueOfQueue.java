package org.tp0.implementations;

import org.tp0.models.IQueueOfQueue;
import org.tp0.models.Queue;


public class QueueOfQueue implements IQueueOfQueue {

    private Queue[] queues;
    private int count;

    public QueueOfQueue() {
        this.queues = new Queue[1000];
        this.count = 0;
    }

    @Override
    public IQueueOfQueue concatenate(IQueueOfQueue[] queue) {
        IQueueOfQueue queueOfQueue = new QueueOfQueue();
        for (int i = 0; i < count; i++) {
            queueOfQueue.addQueue(queues[i]);
        }
        for (int i = 0; i < queue.length; i++) {
            for (int j = 0; j < queue[i].size(); j++) {
                queueOfQueue.addQueue(queue[i].getQueue(j));
            }
        }

        return queueOfQueue;
    }

    @Override
    public void addQueue(Queue queue) {
        if (this.count == 1000) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        this.queues[this.count] = queue;
        this.count++;
    }

    @Override
    public Queue getQueue(int index) {
        return this.queues[index];
    }


    @Override
    public void print() {
        for (int i = 0; i < this.count; i++) {
            queues[i].printQueue();
        }
    }

    @Override
    public Queue[] getQueues() {
        return this.queues;
    }

    @Override
    public int size() {
        return this.count;
    }
}

