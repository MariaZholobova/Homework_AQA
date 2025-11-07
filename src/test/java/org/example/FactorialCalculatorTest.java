package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {
        FactorialCalculator calc = new FactorialCalculator();
        long result = calc.factorial(0);
        assertEquals(1, result, "Факториал 0 должен быть равен 1");
    }

    @Test
    void testFactorialOfFive() {
        FactorialCalculator calc = new FactorialCalculator();
        long result = calc.factorial(5);
        assertEquals(120, result, "Факториал 5 должен быть равен 120");
    }

    @Test
    void testFactorialOfNegativeNumber() {
        FactorialCalculator calc = new FactorialCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-3),
                "Должно быть выброшено исключение при отрицательном числе");
    }
}
