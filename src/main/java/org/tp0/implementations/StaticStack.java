package org.tp0.implementations;


import org.tp0.models.Stack;

public class StaticStack implements Stack {

    private final int[] array;
    private int count;

    public StaticStack(int tamaño) {
        this.array = new int[tamaño];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        if (this.count >= array.length) {
            throw new RuntimeException("Limite excedido");
        }
        this.array[this.count++] = a;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        this.count--;
    }

    @Override
    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return this.array[this.count - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public void print() {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    public static Stack copy(Stack stack) {
        Stack copy = new StaticStack(stack.getCount());
        Stack aux = new StaticStack(stack.getCount());

        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }

        while (!aux.isEmpty()) {
            stack.add(aux.getTop());
            copy.add(aux.getTop());
            aux.remove();
        }

        return copy;
    }

    public int get(int index) {
        return this.array[index];
    }

}
