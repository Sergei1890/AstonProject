package ru.pavlov;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FactorialTest {
    private final Factorial calculator = new Factorial();

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    public void softTestFactorialOfNumber() {
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(calculator.factorial(1)).isEqualTo(1);
        soft.assertThat(calculator.factorial(2)).isEqualTo(2);
        soft.assertThat(calculator.factorial(3)).isEqualTo(6);
        soft.assertThat(calculator.factorial(6)).isEqualTo(720);
        soft.assertAll();
    }

    @Test
    public void testFactorialOfMaxNumber() {
        assertThrows(NumberTooLargeException.class, () -> calculator.factorial(21));
    }

    @Test
    //Для любого n > 9:
    public void testFactorialOfBigNumber9() {
        assertEquals(0, (calculator.factorial(11)) % 100);
    }

    @Test
    public void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }
}

