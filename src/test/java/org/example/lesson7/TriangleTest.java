package org.example.lesson7;

import org.testng.annotations.Test;
import org.testng.Assert;

public class TriangleTest {

    @Test
    public void testAreaCalculatorValidTriangle() {
        Triangle t = new Triangle();
        double area = t.areaCalculator(15, 20, 30);
        Assert.assertEquals(area, 133.31705629813464, "Площадь должна быть равна 133.31705629813464");
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Стороны треугольника должны иметь положительное значение")
    public void testAreaCalculatorNegativeSide() {
        Triangle t = new Triangle();
        t.areaCalculator(-15, 20, 30);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Стороны треугольника должны иметь положительное значение")
    public void testAreaCalculatorZeroSide() {
        Triangle t = new Triangle();
        t.areaCalculator(0, 20, 30);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Треугольник с такими сторонами не существует")
    public void testAreaCalculatorInvalidTriangle() {
        Triangle t = new Triangle();
        t.areaCalculator(10, 20, 30);
    }
}
