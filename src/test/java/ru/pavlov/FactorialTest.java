package ru.pavlov;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.factorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Factorial.factorial(1), 1);
        soft.assertEquals(Factorial.factorial(2), 2);
        soft.assertEquals(Factorial.factorial(6), 720);
        soft.assertAll();
    }

    @Test
    public void testFactorialBigNumbers() {
        assertEquals(Factorial.factorial(20), 2432902008176640000L);
    }

    @Test
    //Для любого n > 9:
    public void testFactorialOfMoreThanNine() {
        assertEquals((Factorial.factorial(10)) % 100, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumber() {
        Factorial.factorial(-1);
    }

    @Test(expectedExceptions = NumberTooLargeException.class)
    public void testMaxNumber() {
        Factorial.factorial(21);
    }
}
