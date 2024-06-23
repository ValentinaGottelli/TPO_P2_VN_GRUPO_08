package org.tp0.implementations.ejercicioTres;

import org.tp0.implementations.StaticQueue;
import org.tp0.models.IQueueOfQueue;
import org.tp0.models.Queue;

import static org.tp0.implementations.StaticQueue.copy;


public class QueueOfQueue implements IQueueOfQueue {

    private Queue[] queues;
    private int count;

    public QueueOfQueue() {
        this.queues = new Queue[1000];
        this.count = 0;
    }

    //ejercico 3-1
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

    //Ejercicio 3-2
    @Override
    public Queue flat() {
        Queue queue = new StaticQueue();

        for (int i = 0; i < this.count; i++) {
            Queue copy = copy(getQueue(i));
            while (!copy.isEmpty()) {
                queue.add(copy.getFirst());
                copy.remove();
            }
        }

        return queue;
    }


    public IQueueOfQueue reverseWithDepth() {
        QueueOfQueue reversedQueue = new QueueOfQueue();
        for (int i = this.size() - 1; i >= 0; i--) {
            reversedQueue.addQueue(this.getQueue(i).reverse());
        }
        return reversedQueue;
    }


}

