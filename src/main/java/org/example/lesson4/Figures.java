/*Задание 2
Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник,
треугольник.
Задать для каждой фигуры цвет заливки и цвет границы.
Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль.
Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве дефолтных методов в интерфейсе.*/

package org.example.lesson4;

public interface Figures {
    double calculateSquare();

    double calculatePerimeter();

    String getFillColor();

    String getBorderColor();

    default double calculateGetPerimeter() {
        if (this instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) this;
            return 2 * (rectangle.getWidth() + rectangle.getLength());
        } else if (this instanceof Circle) {
            Circle circle = (Circle) this;
            return 2 * Math.PI * circle.getRadius();
        } else if (this instanceof Triangle) {
            Triangle triangle = (Triangle) this;
            return triangle.getA() + triangle.getB() + triangle.getC();
        } else {
            return 0;
        }
    }
}
