package org.tp0.implementations;

import org.tp0.models.Queue;

public class StaticQueue implements Queue {

    private final int[] array;
    private int count;

    public StaticQueue() {
        array = new int[10000];
        count = 0;
    }

    @Override
    public void add(int a) {
        if (count == 10000) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for (int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return array[0];
    }

    @Override
    public void printQueue() {
        System.out.printf("[");
        for (int i = 0; i < this.getSize(); i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println("]");
    }

    @Override
    public int getSize() {
        return this.count;
    }

}
