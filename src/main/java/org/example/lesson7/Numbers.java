package org.example.lesson7;

public class Numbers {
    public int sumNumbers(int a, int b) {
        return a + b;
    }

    public int subtractNumbers(int a, int b) {
        return a - b;
    }

    public int multiplyNumbers(int a, int b) {
        return a * b;
    }

    public double divideNumbers(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("На ноль делить нельзя");
        }
        return (double) a / b;
    }
}
