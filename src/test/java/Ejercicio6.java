import org.junit.Test;
import org.tp0.implementations.ejercicioDos.StaticSet;
import org.tp0.implementations.ejercicioSeis.DynamicQueueTwiceLinked;
import org.tp0.implementations.ejercicioSeis.DynamicStack;
import org.tp0.implementations.ejercicioSeis.SetWithTuples;
import org.tp0.implementations.ejercicioSeis.SuperConjunto;
import org.tp0.models.ITupleForSet;
import org.tp0.models.Set;
import org.tp0.models.Stack;

import static org.junit.Assert.*;

public class Ejercicio6 {

    @Test
    public void dynamicStackthrowsExceptionWhenFull() {
        DynamicStack stack = new DynamicStack(2);

        stack.add(1);
        stack.add(2);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            stack.add(3);
        });

        assertEquals("El stack esta completo", exception.getMessage());
    }


    @Test
    public void esSubconjuntoTest() {
        SuperConjunto superConjunto = new SuperConjunto();
        superConjunto.add(1);
        superConjunto.add(2);
        superConjunto.add(3);
        superConjunto.add(4);

        Set set = new StaticSet();
        set.add(1);
        set.add(2);

        assertEquals(true, superConjunto.esSubconjunto(set));
    }

    @Test
    public void complementoTest() {
        SuperConjunto superConjunto = new SuperConjunto();
        superConjunto.add(1);
        superConjunto.add(2);
        superConjunto.add(3);
        superConjunto.add(4);

        Set set = new StaticSet();
        set.add(1);
        set.add(2);

        Set complemento = superConjunto.complemento(set);
        Set expected = new StaticSet();
        expected.add(3);
        expected.add(4);
        complemento.print();

        //siempre deberia ser true pero puede pasar que lea al reves los arrays
        assertArrayEquals(expected.getArray(), complemento.getArray());
    }

    @Test
    public void colaCiclicaDoblementeEnlazada() {

        DynamicQueueTwiceLinked dynamicQueueTwiceLinked = new DynamicQueueTwiceLinked();

        dynamicQueueTwiceLinked.add(1);
        dynamicQueueTwiceLinked.add(2);
        dynamicQueueTwiceLinked.add(3);

        //este test lo utilizo para debuguear y ver el funcionamiento de la cola ciclica doblemente enlazada

        dynamicQueueTwiceLinked.remove();

        assertEquals(dynamicQueueTwiceLinked.getFirst(), 1);
    }

    @Test
    public void conjuntoConRepetidos() {
        ITupleForSet tuple = new SetWithTuples();

        tuple.add(1);
        tuple.add(1);
        tuple.add(2);
        tuple.add(3);

        tuple.remove(2);

        assertEquals(tuple.get(1), 2);
    }
}
