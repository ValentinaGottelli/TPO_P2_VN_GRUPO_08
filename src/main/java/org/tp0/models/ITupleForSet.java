package org.tp0.models;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface ITupleForSet {

    /**
     * Agrega un valor
     *
     * @param k -
     */
    void add(int k);

    /**
     * Eliminamos el valor de la tupla con su contador
     *
     * @param k -
     */
    void remove(int k);

    /**
     * Devuelve la cantidad de veces que se repite ese valor
     * Precondición: No se puede obtener un valor de una key que no existe.
     *
     * @param k -
     * @return canntidad de veces que se repite el valor
     */
    int get(int k);

}
