package org.example.lesson7;

import org.testng.annotations.Test;
import org.testng.Assert;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        FactorialCalculator calc = new FactorialCalculator();
        long result = calc.factorial(0);
        Assert.assertEquals(result, 1, "Факториал 0 должен быть равен 1");
    }

    @Test
    public void testFactorialOfFive() {
        FactorialCalculator calc = new FactorialCalculator();
        long result = calc.factorial(5);
        Assert.assertEquals(result, 120, "Факториал 5 должен быть равен 120");
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Факториал отрицательного числа не существует")
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator calc = new FactorialCalculator();
        calc.factorial(-3);
    }
}
