package org.tp0.implementations.ejercicioUno;

import org.tp0.implementations.ejercicioDos.StaticStack;
import org.tp0.models.IQueueOfStacks;
import org.tp0.models.Stack;

import static org.tp0.implementations.ejercicioDos.StaticStack.reverseStack;

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

    /**
     *en este caso antes de ingresar a cada stack del queue, lo vamos a dar vuelta
     * para que el get trate al array como un stack, ya que vamos recorriendo de atras
     * hacia adelante y queremos agarrar los valores del tope del Stack
     * @param queueOfStacks
     * @return
     */
    //Complejidad de O(N+N^3) = O(N^3)
    public static QueueOfStacks traspuesta(QueueOfStacks queueOfStacks) {
        QueueOfStacks traspuesta = new QueueOfStacks(queueOfStacks.getN()); //O(N)

        for (int i = 0; i < queueOfStacks.getN(); i++) { //N
            for (int j = 0; j < queueOfStacks.getN(); j++) {//N
                traspuesta.stacks[j].add(reverseStack(queueOfStacks.stacks[i]).get(j));//N

            }
        }

        return traspuesta;
    }

    //Complejidad de O(N+N*8N) = O(N+8N^2) = O(N^2)
    public static QueueOfStacks sumaMatricial(QueueOfStacks queueOfStacks, QueueOfStacks queueOfStacksSecond) {
        QueueOfStacks total = new QueueOfStacks(queueOfStacks.getN()); //O(N)

        for (int i = 0; i < queueOfStacks.getN(); i++) { //O(N)
            total.addStack(queueOfStacks.stacks[i].suma(queueOfStacksSecond.stacks[i]));//O(8N)
        }

        return total;
    }


    public void printQueueOfStacks() {

        int maxSize = 0;
        for (Stack stack : stacks) {
            if (stack.getCount() > maxSize) {
                maxSize = stack.getCount();
            }
        }

        for (int i = maxSize - 1; i >= 0; i--) {
            for (Stack stack : stacks) {
                if (i < stack.getCount()) {
                    System.out.print(stack.getArray()[i] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
