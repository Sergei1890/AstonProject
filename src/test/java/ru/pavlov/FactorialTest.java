package ru.pavlov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    private Factorial calculator = new Factorial();

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    public void testFactorialOfNumber() {
        assertEquals(1, calculator.factorial(1));
        assertEquals(2, calculator.factorial(2));
        assertEquals(6, calculator.factorial(3));
        assertEquals(720, calculator.factorial(6));
    }

    @Test
        //Для любого n > 9:
    public void testFactorialOfBigNumber() {
        assertEquals(0, (calculator.factorial(10))%100);
    }

    @Test
    public void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-2));
    }
}

