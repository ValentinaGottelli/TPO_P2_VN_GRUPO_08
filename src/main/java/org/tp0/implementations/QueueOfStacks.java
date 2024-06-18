package org.tp0.implementations;

import org.tp0.models.IQueueOfStacks;
import org.tp0.models.Stack;


public class QueueOfStacks implements IQueueOfStacks {

    private Stack[] stacks;
    private int n;
    private int count;

    //tamaño de nxn
    public QueueOfStacks(int n) {
        this.stacks = new StaticStack[n];
        for (int i = 0; i < n; i++) {
            stacks[i] = new StaticStack(n);
        }
        this.n = n;
        this.count = 0;
    }

    public int getN() {
        return this.n;
    }

    @Override
    public void addStack(Stack stack) {
        if (this.count >= stacks.length) {
            throw new RuntimeException("Limite excedido");
        }
        if (stack.getCount() != this.n) {
            throw new RuntimeException("El tamaño del stack a agregar es incorrecto");
        }
        stacks[count] = stack;
        count++;
    }

    public static int calculoTraza(QueueOfStacks queueOfStacks) {
        int trace = 0;
        for (int i = 0; i < queueOfStacks.getN(); i++) {
            trace += queueOfStacks.stacks[i].get(i);
        }
        return trace;
    }

}
