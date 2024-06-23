package org.tp0.implementations.ejercicioDos;


import org.tp0.models.Set;

import java.util.Random;

public class StaticSet implements Set {

    private static final int MAX = 10000;

    private int[] array;
    private int count;

    public StaticSet() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        if (count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for (int i = 0; i < count; i++) {
            if (this.array[i] == a) {
                return;
            }
        }
        this.array[count] = a;
        this.count++;
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < count; i++) {
            if (this.array[i] == a) {
                this.array[i] = this.array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");
        }
        return this.array[new Random().nextInt(this.count)];
    }

    @Override
    public void print() {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    // 2.2 ejercicio 2
    public static Set copy(Set set) {
        Set copy = new StaticSet();
        Set aux = new StaticSet();
        while (!set.isEmpty()) {
            int element = set.choose();
            copy.add(element);
            aux.add(element);
            set.remove(element);
        }

        while (!aux.isEmpty()) {
            int element = aux.choose();
            set.add(element);
            aux.remove(element);
        }

        return copy;
    }
}
