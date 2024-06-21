package org.tp0.models;

import org.tp0.implementations.QueueOfQueue;
import org.tp0.implementations.StaticQueue;

import java.util.List;

public interface IQueueOfQueue {

    IQueueOfQueue concatenate(IQueueOfQueue[] queue);

    void addQueue(Queue queue);

    Queue getQueue(int index);

    void print();

    Queue[] getQueues();

    int size();

}
