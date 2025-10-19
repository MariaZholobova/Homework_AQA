package org.example.lesson4;

public class Rectangle implements Figures {
    private double length;
    private double width;
    private String fillColor;
    private String borderColor;

    public Rectangle(double length, double width, String fillColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateSquare() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void printInfo() {
        System.out.println("Прямоугольник: ");
        System.out.println("Площадь: " + calculateSquare());
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("___________________________");
    }
}
