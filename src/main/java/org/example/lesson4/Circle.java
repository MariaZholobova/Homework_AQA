package org.example.lesson4;

public class Circle implements Figures {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateSquare() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    public double getRadius() {
        return radius;
    }

    public void printInfo() {
        System.out.println("Круг: ");
        System.out.println("Площадь: + " + calculateSquare());
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("___________________________");
    }
}
