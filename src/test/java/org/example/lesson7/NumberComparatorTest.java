package org.example.lesson7;

import org.testng.annotations.Test;
import org.testng.Assert;

public class NumberComparatorTest {

    @Test
    public void testCompareNumbersLess() {
        NumberComparator c = new NumberComparator();
        String result = c.compareNumbers(10, 15);
        Assert.assertEquals(result, "Первое число меньше второго", "Должно вернуть сообщение, что Первое число меньше второго");
    }

    @Test
    public void testCompareNumbersGreater() {
        NumberComparator c = new NumberComparator();
        String result = c.compareNumbers(55, 15);
        Assert.assertEquals(result, "Первое число больше второго", "Должно вернуть сообщение, что Первое число больше второго");
    }

    @Test
    public void testCompareNumbersEqual() {
        NumberComparator c = new NumberComparator();
        String result = c.compareNumbers(10, 10);
        Assert.assertEquals(result, "Числа равны", "Числа должны быть равны");
    }

    @Test
    public void testIsNumberGreater() {
        NumberComparator c = new NumberComparator();
        Assert.assertTrue(c.isNumberGreater(25, 15), "25 больше 15 - true");
        Assert.assertFalse(c.isNumberGreater(10, 15), "10 больше 15 - false");
    }

    @Test
    public void testIsNumberLess() {
        NumberComparator c = new NumberComparator();
        Assert.assertTrue(c.isNumberLess(25, 55), "25 меньше 55 - true");
        Assert.assertFalse(c.isNumberLess(100, 15), "100 меньше 15 - false");
    }

    @Test
    public void testAreNumbersEqual() {
        NumberComparator c = new NumberComparator();
        Assert.assertTrue(c.areNumbersEqual(55, 55), "55 равно 55 - true");
        Assert.assertFalse(c.areNumbersEqual(100, 15), "100 равно 15 - false");
    }
}
