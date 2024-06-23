package org.tp0.implementations.ejercicioDos;


import org.tp0.models.Stack;

public class StaticStack implements Stack {

    private final static int MAX = 100;

    private final int[] array;
    private int count;

    public StaticStack(int tamaño) {
        this.array = new int[tamaño];
        this.count = 0;
    }

    public StaticStack() {
        this.array = new int[MAX];
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

    //O(2N)
    public static Stack copy(Stack stack) {
        Stack copy = new StaticStack(stack.getCount());
        Stack aux = new StaticStack(stack.getCount());

        while (!stack.isEmpty()) { //O(N)
            aux.add(stack.getTop());
            stack.remove();
        }

        while (!aux.isEmpty()) {//O(N)
            stack.add(aux.getTop());
            copy.add(aux.getTop());
            aux.remove();
        }

        return copy;
    }

    //2.2 Ej 1
    //3N = N
    public static Stack reverseStack(Stack stack) {
        Stack copy = copy(stack); //2N
        Stack reversed = new StaticStack(stack.getCount());

        while (!copy.isEmpty()) { //N
            reversed.add(copy.getTop());
            copy.remove();
        }
        return reversed;
    }

    public int get(int index) { //C
        return this.array[index];
    }

    @Override
    public int[] getArray() {
        return this.array;
    }

    //O(8N)
    @Override
    public Stack suma(Stack stack) {
        Stack total = new StaticStack(this.getCount());
        Stack copia1 = copy(this);//2N
        Stack copia2 = copy(stack);//2N

        while (!copia1.isEmpty()) { //N
            total.add(copia1.getTop() + copia2.getTop());
            copia1.remove();
            copia2.remove();
        }

        //lo devuelvo alrevez ya que al hacer la suma el tope va hacia abajo
        // cuando queremos que se mantenga en la misma posicion del stack
        //al hacer la suma
        //3N
        return reverseStack(total);
    }
}
