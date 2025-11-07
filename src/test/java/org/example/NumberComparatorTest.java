package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberComparatorTest {

    @Test
    void testCompareNumbersLess() {
        NumberComparator c = new NumberComparator();
        String result = c.compareNumbers(10, 15);
        assertEquals("Первое число меньше второго", result, "Должно вернуть сообщение, что Первое число меньше второго");
    }

    @Test
    void testCompareNumbersGreater() {
        NumberComparator c = new NumberComparator();
        String result = c.compareNumbers(55, 15);
        assertEquals("Первое число больше второго", result, "Должно вернуть сообщение, что Первое число больше второго");
    }

    @Test
    void testCompareNumbersEqual() {
        NumberComparator c = new NumberComparator();
        String result = c.compareNumbers(10, 10);
        assertEquals("Числа равны", result, "Числа должны быть равны");
    }

    @Test
    void testIsNumberGreater() {
        NumberComparator c = new NumberComparator();
        assertTrue(c.isNumberGreater(25, 15), "25 больше 15 - true");
        assertFalse(c.isNumberGreater(10, 15), "10 больше 15 - false");
    }

    @Test
    void testIsNumberLess() {
        NumberComparator c = new NumberComparator();
        assertTrue(c.isNumberLess(25, 55), "25 меньше 55 - true");
        assertFalse(c.isNumberLess(100, 15), "100 меньше 15 - false");
    }

    @Test
    void testAreNumbersEqual() {
        NumberComparator c = new NumberComparator();
        assertTrue(c.areNumbersEqual(55, 55), "55 равно 55 - true");
        assertFalse(c.areNumbersEqual(100, 15), "100 равно 15 - false");
    }
}
