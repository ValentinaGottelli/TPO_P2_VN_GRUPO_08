package org.tp0.implementations;

import org.tp0.models.IQueueOfStacks;
import org.tp0.models.Stack;


public class QueueOfStacks implements IQueueOfStacks {

    private Stack[] stacks;
    private int n;
    private int count;


    //O(N)
    //tamaño de nxn
    public QueueOfStacks(int n) {
        this.stacks = new StaticStack[n];
        for (int i = 0; i < n; i++) { //N
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

    //Complejidad de O(n)
    public static int calculoTraza(QueueOfStacks queueOfStacks) {
        int trace = 0;
        for (int i = 0; i < queueOfStacks.getN(); i++) { // N
            trace += queueOfStacks.stacks[i].get(i);
        }
        return trace;
    }

    //Complejidad de O(N+N^2)
    public static QueueOfStacks traspuesta(QueueOfStacks queueOfStacks) {
        QueueOfStacks traspuesta = new QueueOfStacks(queueOfStacks.getN()); //O(N)

        for (int i = 0; i < queueOfStacks.getN(); i++) { //N
            for (int j = 0; j < queueOfStacks.getN(); j++) {//N
                traspuesta.stacks[j].add(queueOfStacks.stacks[i].get(j));//c
            }
        }

        return traspuesta;
    }

    public void printMatrix() {
        for (Stack stack : stacks) {
            int[] array = stack.getArray();
            for (int value : array) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }


    }
}
