package org.tp0.models;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface Stack {

    /**
     * Postcondicion: Apila (coloca en el tope) un valor.
     *
     * @param a valor a apilar.
     */
    void add(int a);

    /**
     * Precondicion: La pila no esta vacia.
     * Postcondicion: Desapila (quita el tope).
     */
    void remove();

    /**
     * @return <code>true</code> si la pila esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return tope de la pila
     */
    int getTop();

    void print();

    int getCount();

    /**
     * Obtengo el valor asociado al index solicitado
     *
     * @param index
     * @return
     */
    int get(int index);

    /**
     * solamente es usado para poder visualizar la QueueOfStacks
     *
     * @return
     */
    int[] getArray();

    /**
     * obtenemos el total de un stack con otro
     *
     * @param stack
     * @return
     */
    Stack suma(Stack stack);

}
