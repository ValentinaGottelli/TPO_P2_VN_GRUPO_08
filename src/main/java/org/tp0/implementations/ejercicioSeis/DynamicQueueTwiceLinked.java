package org.tp0.implementations.ejercicioSeis;

import org.tp0.models.Queue;

public class DynamicQueueTwiceLinked implements Queue {

    private NodeTwiceLinked first;
    private int count;


    @Override
    public void add(int a) {
        NodeTwiceLinked node = new NodeTwiceLinked(a, null, null);
        if (this.first == null) {
            // si la cola esta vacia, el nuevo nodo es el primer nodo
            this.first = node;
            // el nodo apunta a si mismo para mantener la estructura ciclica
            this.first.setNext(this.first);
            this.first.setPrevious(this.first);
        } else {
            // encuentra el ultimo nodo
            NodeTwiceLinked last = this.first.getPrevious();
            // cambio las referencias del nuevo nodo
            node.setNext(this.first); // el nuevo nodo apunta al primero
            node.setPrevious(last); // el nuevo nodo apunta al ultimo
            // actualiza las referencias del ultimo nodo y el primer nodo
            last.setNext(node); // el ultimo nodo apunta al nuevo nodo
            this.first.setPrevious(node); // el primer nodo apunta al nuevo nodo
        }
        count++;
    }

    @Override
    public void remove() {
        if (this.first == null) {
            return;
        }

        if (this.first.getNext() == this.first) {
            // solo hay un nodo en la cola
            this.first = null;
        } else {
            // hay mas de un nodo en la cola
            NodeTwiceLinked last = this.first.getPrevious();
            NodeTwiceLinked penultimate = last.getPrevious();

            // actualiza las referencias para eliminar el ultimo nodo
            penultimate.setNext(this.first);
            this.first.setPrevious(penultimate);
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getFirst() {
        if (this.first == null) {
            throw new RuntimeException("Queue is empty");
        }
        return this.first.getValue();
    }

    @Override
    public void printQueue() {

    }

    @Override
    public int getSize() {
        return this.count;
    }

    @Override
    public Queue reverse() {
        return null;
    }
}
