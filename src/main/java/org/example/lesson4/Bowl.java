package org.example.lesson4;

public class Bowl {
    private int food;

    public Bowl(int food) {
        if (food < 0) food = 0;
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void eatFood(int amount) {
        if (amount <= food) {
            food -= amount;
        } else {
            System.out.println("В миске недостаточно еды");
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("В миску добавлено: " + amount + " еды. Всего еды: " + food);
        }
    }
}
