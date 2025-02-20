package ru.pavlov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.assertj.core.api.SoftAssertions;

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
    //Для любого n > 9:
    public void testFactorialOfBigNumber() {
        assertEquals(0, (calculator.factorial(10)) % 100);
    }

    @Test
    public void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-2));
    }
}

