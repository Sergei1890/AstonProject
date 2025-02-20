package ru.pavlov;

public class Factorial {
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Отрицательное число недопустимо");
        }

        if (n > 20) {
            throw new NumberTooLargeException("Не доступно, для n > 20");
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
