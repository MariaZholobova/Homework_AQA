package org.example.lesson5;

/*Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
и вывести результат расчета.

Напишите код для генерации и поимки ArrayIndexOutOfBoundsException.*/
public class Main {
    public static int sumArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Количество строк должно быть равно 4. А сейчас: " + array.length);
        }

        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Количество столбцов должно быть равно 4. А сейчас: " + array[i].length);
            }
        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!array[i][j].matches("-?\\d+")) {
                    throw new MyArrayDataException("Ошибка в ячейке: [" + i + "][" + j + "]: " + array[i][j]);
                }
                sum += Integer.parseInt(array[i][j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "XI", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = sumArray(arr);
            System.out.println("Сумма равна: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера! " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных! " + e.getMessage());
        }

        try {
            System.out.println(arr[10][10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход индекса за пределы массива! " + e.getMessage());
        }
    }
}
