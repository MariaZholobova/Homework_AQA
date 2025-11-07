package org.example;

public class FactorialCalculator {
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число не может быть меньше нуля");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
