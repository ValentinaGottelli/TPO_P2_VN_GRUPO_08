package org.tp0.implementations.ejercicioSeis;


import org.tp0.models.Node;
import org.tp0.models.Stack;

import java.util.Objects;

public class DynamicStack implements Stack {

    private Node first;
    private int capacity;
    private int count;

    public DynamicStack(int capacity) {
        this.capacity = capacity;
        this.count = 0;
    }

    @Override
    public void add(int a) {
        if (count >= capacity) {
            throw new RuntimeException("El stack esta completo");
        }
        this.first = new Node(a, this.first);
        count++;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        this.first = this.first.getNext();
    }

    @Override
    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        return this.first.getValue();
    }

    @Override
    public void print() {
    }

    @Override
    public int getCount() {
        return this.count;
    }


    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int[] getArray() {
        return new int[0];
    }

    @Override
    public Stack suma(Stack stack) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }
}
