package org.example.lesson4;

public class Dog extends Animal {
    static int countDogs = 0;

    public Dog(String name) {
        super(name);
        countDogs++;
    }

    @Override
    public void run(int length) {
        if (length <= 500) {
            System.out.println(name + " пробежал: " + length + " м. ");
        } else {
            System.out.println(name + " не может пробежать: " + length + " м. ");
        }
    }

    @Override
    public void swim(int length) {
        if (length <= 10) {
            System.out.println(name + " проплыл: " + length + " м. ");
        } else {
            System.out.println(name + " не может проплыть: " + length + " м. ");
        }
    }
}
