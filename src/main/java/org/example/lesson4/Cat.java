package org.example.lesson4;

public class Cat extends Animal {
    static int countCats = 0;
    boolean isFullness;

    public Cat(String name) {
        super(name);
        countCats++;
        isFullness = false;
    }

    @Override
    public void run(int length) {
        if (length <= 200) {
            System.out.println(name + " пробежал: " + length + " м. ");
        } else {
            System.out.println(name + " не может пробежать: " + length + " м. ");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println(name + " не умеет плавать");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.eatFood(amount);
            this.isFullness = true;
            System.out.println(name + " поел и теперь сыт");
        } else {
            System.out.println(name + " не будет есть, еды мало");
        }
    }
}
