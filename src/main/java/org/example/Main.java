package org.example;

public class Main {
    public static void main(String[] args) {
        FactorialCalculator calc = new FactorialCalculator();
        System.out.println(calc.factorial(5));

        Triangle t = new Triangle();
        System.out.println(t.areaCalculator(20, 15, 30));

        Numbers numbers = new Numbers();
        System.out.println("Сумма чисел: " + numbers.sumNumbers(5, 10));
        System.out.println("Разность чисел: " + numbers.subtractNumbers(5, 10));
        System.out.println("Умножение чисел: " + numbers.multiplyNumbers(5, 10));
        System.out.println("Деление чисел: " + numbers.divideNumbers(5, 10));

        NumberComparator c = new NumberComparator();
        System.out.println("Результат сравнения: " + c.compareNumbers(-5, 10));
        System.out.println("Результат сравнения: " + c.isNumberGreater(10, 5));
        System.out.println("Результат сравнения: " + c.isNumberLess(10, 5));
        System.out.println("Результат сравнения: " + c.areNumbersEqual(10, 10));
    }
}
