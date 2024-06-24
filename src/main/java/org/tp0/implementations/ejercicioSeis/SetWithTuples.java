package org.tp0.implementations.ejercicioSeis;

import org.tp0.models.ITupleForSet;

public class SetWithTuples implements ITupleForSet {
    private static final int MAX = 10000;

    private int[][] array;
    private int count;

    public SetWithTuples() {
        this.array = new int[MAX][MAX];
        this.count = 0;
    }


    @Override
    public void add(int k) {
        if (count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for (int i = 0; i < count; i++) {
            if (this.array[i][0] == k) {
                this.array[i][1] += 1;
                return;
            }
        }
        this.array[count] = new int[2];
        this.array[count][0] = k;
        this.array[count][1] = 1;
        this.count++;
    }

    @Override
    public void remove(int k) {
        for (int i = 0; i < count; i++) {
            if (this.array[i][0] == k) {
                this.array[i] = this.array[count - 1];
                count--;
                return;
            }
        }

        throw new RuntimeException("No existe el valor");
    }

    @Override
    public int get(int k) {
        for (int i = 0; i < count; i++) {
            if (this.array[i][0] == k) {
                return array[i][1];
            }
        }
        throw new RuntimeException("No existe un valor asociado al elemento");
    }
}
