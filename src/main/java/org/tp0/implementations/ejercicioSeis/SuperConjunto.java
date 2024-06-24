package org.tp0.implementations.ejercicioSeis;

import org.tp0.implementations.ejercicioDos.StaticSet;
import org.tp0.models.Set;

import java.util.Random;

public class SuperConjunto implements Set {
    private static final int MAX = 10000;

    private int[] array;
    private int count;

    public SuperConjunto() {
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

    @Override
    public int[] getArray() {
        return this.array;
    }

    public static boolean in(Set a, int element) {
        Set aux = new StaticSet();
        boolean exists = false;
        while (!a.isEmpty()) {
            int value = a.choose();
            if (element == value) {
                exists = true;
                break;
            }
            aux.add(value);
            a.remove(value);
        }
        while (!aux.isEmpty()) {
            int value = aux.choose();
            a.add(value);
            aux.remove(value);
        }
        return exists;
    }


    public boolean esSubconjunto(Set set) {
        Set aux = new StaticSet();
        boolean subset = true;
        while (!set.isEmpty()) {
            int element = set.choose();
            if (!in(this, element)) {
                subset = false;
                break;
            }
            aux.add(element);
            set.remove(element);
            this.remove(element);
        }
        if (this.isEmpty()) {
            subset = false;
        }
        while (!aux.isEmpty()) {
            int element = aux.choose();
            set.add(element);
            this.add(element);
            aux.remove(element);
        }
        return subset;

    }

    public Set complemento(Set set) {
        if (!this.esSubconjunto(set)) {
            throw new RuntimeException("No es subconjunto del superconjunto");
        }
        Set aux = new StaticSet();
        Set result = new StaticSet();
        while (!this.isEmpty()) {
            int element = this.choose();
            aux.add(element);
            if (!in(set, element)) {
                result.add(element);
            }
            this.remove(element);
        }
        while (!aux.isEmpty()) {
            int element = aux.choose();
            this.add(element);
            aux.remove(element);
        }
        return result;
    }
}
