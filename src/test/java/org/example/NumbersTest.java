package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumbersTest {

    @Test
    void testSumNumbers() {
        Numbers numbers = new Numbers();
        int sum = numbers.sumNumbers(5, 10);
        assertEquals(15, sum, "Сумма должна быть равна 15");
    }

    @Test
    void testSubtractNumbers() {
        Numbers numbers = new Numbers();
        int result = numbers.subtractNumbers(-5, 10);
        assertEquals(-15, result, "Разность должна быть равна -15");
    }

    @Test
    void testMultiplyNumbers() {
        Numbers numbers = new Numbers();
        int result = numbers.multiplyNumbers(5, 10);
        assertEquals(50, result, "Результат умножения должен быть равен 50");
    }

    @Test
    void testDivideNumbers() {
        Numbers numbers = new Numbers();
        double result = numbers.divideNumbers(5, 10);
        assertEquals(0.5, result, "Результат деления должен быть равен 0.5");
    }

    @Test
    void testDivideOfZero() {
        Numbers numbers = new Numbers();
        assertThrows(IllegalArgumentException.class, () -> numbers.divideNumbers(5, 0),
                "Должно выбрасываться исключение при делении на ноль");
    }
}
