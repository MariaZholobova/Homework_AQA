package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    void testAreaCalculatorValidTriangle() {
        Triangle t = new Triangle();
        double area = t.areaCalculator(15, 20, 30);
        assertEquals(133.31705629813464, area, "Площадь должна быть равна 133.31705629813464");
    }

    @Test
    void testAreaCalculatorNegativeSide() {
        Triangle t = new Triangle();
        assertThrows(IllegalArgumentException.class, () -> t.areaCalculator(-15, 20, 30),
                "Должно выбрасываться исключение при отрицательной стороне");
    }

    @Test
    void testAreaCalculatorZeroSide() {
        Triangle t = new Triangle();
        assertThrows(IllegalArgumentException.class, () -> t.areaCalculator(0, 20, 30),
                "Должно выбрасываться исключение при нулевой стороне");
    }

    @Test
    void testAreaCalculatorInvalidTriangle() {
        Triangle t = new Triangle();
        assertThrows(IllegalArgumentException.class, () -> t.areaCalculator(10, 20, 30),
                "Должно выбрасываться исключение для невозможного треугольника");
    }
}
