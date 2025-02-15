package ru.pavlov;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FacorialTest {
    private Factorial calculator = new Factorial();

    @Test
    void testFactorialOfZero() {
        assertEquals(calculator.factorial(0), 1);
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(calculator.factorial(1), 1);
        assertEquals(calculator.factorial(2), 2);
        assertEquals(calculator.factorial(6), 720);
    }




}
