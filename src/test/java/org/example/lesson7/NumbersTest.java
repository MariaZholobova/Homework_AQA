package org.example.lesson7;

import org.testng.annotations.Test;
import org.testng.Assert;

public class NumbersTest {

    @Test
    public void testSumNumbers() {
        Numbers numbers = new Numbers();
        int sum = numbers.sumNumbers(5, 10);
        Assert.assertEquals(sum, 15, "Сумма должна быть равна 15");
    }

    @Test
    public void testSubtractNumbers() {
        Numbers numbers = new Numbers();
        int result = numbers.subtractNumbers(-5, 10);
        Assert.assertEquals(result, -15, "Разность должна быть равна -15");
    }

    @Test
    public void testMultiplyNumbers() {
        Numbers numbers = new Numbers();
        int result = numbers.multiplyNumbers(5, 10);
        Assert.assertEquals(result, 50, "Результат умножения должен быть равен 50");
    }

    @Test
    public void testDivideNumbers() {
        Numbers numbers = new Numbers();
        double result = numbers.divideNumbers(5, 10);
        Assert.assertEquals(result, 0.5, "Результат деления должен быть равен 0.5");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "На ноль делить нельзя")
    public void testDivideOfZero() {
        Numbers numbers = new Numbers();
        numbers.divideNumbers(5, 0);
    }
}
