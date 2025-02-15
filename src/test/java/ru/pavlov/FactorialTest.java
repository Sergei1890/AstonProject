package ru.pavlov;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.factorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(Factorial.factorial(1), 1);
        assertEquals(Factorial.factorial(2), 2);
        assertEquals(Factorial.factorial(6), 720);
    }
    @Test
        //Для любого n > 9:
    public void testFactorialOfBigNumber() {
        assertEquals((Factorial.factorial(10))%100, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumber() {
        Factorial.factorial(-1);
    }
}
