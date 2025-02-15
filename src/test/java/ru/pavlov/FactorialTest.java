package ru.pavlov;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    private Factorial calculator = new Factorial();

    @Test
    void testFactorialOfZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void testFactorialOfNumber() {
        assertEquals(1, calculator.factorial(1));
        assertEquals(2, calculator.factorial(2));
        assertEquals(6, calculator.factorial(3));
        assertEquals(720, calculator.factorial(6));
    }

    @Test
        //Для любого n > 9:
    void testFactorialOfBigNumber() {
        assertEquals(0, (calculator.factorial(10))%100);
    }

    @Test
    void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-2));
    }
}

