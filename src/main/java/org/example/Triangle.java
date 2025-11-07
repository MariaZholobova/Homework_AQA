package org.example;

public class Triangle {
    public double areaCalculator(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны иметь положительное значение");
        }
        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
        double p = (a + b + c) / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return area;
    }
}
