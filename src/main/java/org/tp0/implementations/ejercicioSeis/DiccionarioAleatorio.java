package org.tp0.implementations.ejercicioSeis;

import org.tp0.implementations.ejercicioDos.StaticSet;
import org.tp0.models.MultipleDictionary;
import org.tp0.models.Set;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiccionarioAleatorio implements MultipleDictionary {
    //5. Dicccionario aleatorio: Es un diccionario múltiple que al obtener pedir un elemento a partir de una clave,
    // devuelve aleatoriamente alguno de sus valores.

    private static final int MAX = 100;

    private int[][] array;
    private int count;

    public DiccionarioAleatorio() {
        this.array = new int[MAX][MAX];
        this.count = 0;
    }

    @Override
    public void add(int k, int v) {
        if (count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for (int i = 0; i < count; i++) {
            if (this.array[i][0] == k) {
                this.array[i][array[i][1] + 2] = v;
                this.array[i][1]++;
                return;
            }
        }
        this.array[count] = new int[MAX];
        this.array[count][0] = k;
        this.array[count][2] = v;
        this.array[count][1] = 1;
        this.count++;
    }

    @Override
    public void remove(int k, int v) {
        for (int i = 0; i < count; i++) {
            if (this.array[i][0] == k) {
                if (this.array[i][1] == 1) {
                    if (this.array[i][2] == v) {
                        this.array[i] = this.array[count - 1];
                        count--;
                        return;
                    }
                    throw new RuntimeException("No existe el valor para la clave dada");
                }

                for (int j = 0; j < this.array[i][1]; j++) {
                    if (this.array[i][j + 2] == v) {
                        this.array[i][j + 2] = this.array[i][this.array[i][1] + 1];
                        // - 1 (correccion de la ultima posicion)
                        // + 2 (la clave y el total de valores en las posiciones 0 y 1)
                        this.array[i][1]--;
                        return;
                    }
                }
            }
        }
        throw new RuntimeException("No existe la clave");
    }

    @Override
    public Set getKeys() {
        Set set = new StaticSet();
        for (int i = 0; i < count; i++) {
            set.add(this.array[i][0]);
        }
        return set;
    }

    @Override
    public List<Integer> get(int k) {
        for (int i = 0; i < count; i++) {
            if (this.array[i][0] == k) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < array[i][1]; j++) {
                    list.add(array[i][j + 2]);
                }
                return list;
            }
        }
        throw new RuntimeException("No existe un valor asociado a la clave");
    }

    public int getRandomValue(int k) {
        List<Integer> values = get(k);
        if (values.isEmpty()) {
            throw new RuntimeException("No existen valores asociados a la clave");
        }
        int randomIndex = new Random().nextInt(values.size());
        return values.get(randomIndex);
    }
}

