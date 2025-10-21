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
            System.out.println(getName() + " пробежал: " + length + " м. ");
        } else {
            System.out.println(getName() + " не может пробежать: " + length + " м. ");
        }
    }

    @Override
    public void swim(int length) {
        if (length <= 10) {
            System.out.println(getName() + " проплыл: " + length + " м. ");
        } else {
            System.out.println(getName() + " не может проплыть: " + length + " м. ");
        }
    }
}
