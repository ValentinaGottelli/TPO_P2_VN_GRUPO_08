import org.junit.Test;
import org.tp0.implementations.ejercicioSeis.DynamicStack;
import org.tp0.models.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Ejercicio6 {

    @Test
    public void DynamicStackthrowsExceptionWhenFull() {
        DynamicStack stack = new DynamicStack(2);

        stack.add(1);
        stack.add(2);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            stack.add(3);
        });

        assertEquals("El stack esta completo", exception.getMessage());
    }
}
