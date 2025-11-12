package org.example;

public class NumberComparator {
    public String compareNumbers(int a, int b) {
        if (a > b) {
            return ("Первое число больше второго");
        } else if (a < b) {
            return ("Первое число меньше второго");
        } else {
            return ("Числа равны");
        }
    }

    public boolean isNumberGreater(int a, int b) {
        return a > b;
    }

    public boolean isNumberLess(int a, int b) {
        return a < b;
    }

    public boolean areNumbersEqual(int a, int b) {
        return a == b;
    }

    /*Вариант с объединением*/
    public int compare(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }
}
