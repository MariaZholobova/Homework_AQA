package org.example.lesson4;

public class Cat extends Animal {
    static int countCats = 0;
    private boolean isFullness;

    public Cat(String name) {
        super(name);
        countCats++;
        isFullness = false;
    }

    public boolean getIsFullness() {
        return isFullness;
    }

    @Override
    public void run(int length) {
        if (length <= 200) {
            System.out.println(getName() + " пробежал: " + length + " м. ");
        } else {
            System.out.println(getName() + " не может пробежать: " + length + " м. ");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println(getName() + " не умеет плавать");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.eatFood(amount);
            this.isFullness = true;
            System.out.println(getName() + " поел и теперь сыт");
        } else {
            System.out.println(getName() + " не будет есть, еды мало");
        }
    }
}
