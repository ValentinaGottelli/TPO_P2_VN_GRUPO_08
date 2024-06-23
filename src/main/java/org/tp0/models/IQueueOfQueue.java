package org.tp0.models;

public interface IQueueOfQueue {

    IQueueOfQueue concatenate(IQueueOfQueue[] queue);

    void addQueue(Queue queue);

    Queue getQueue(int index);

    void print();

    Queue[] getQueues();

    int size();

    Queue flat();

    IQueueOfQueue reverseWithDepth();
}
