package org.example.lesson4;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Борис");
        Cat cat1 = new Cat("Вася");
        Cat cat2 = new Cat("Бусик");
        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Лапка");
        animal1.run(500);
        animal1.swim(1000);
        cat1.run(100);
        cat1.swim(150);
        dog1.run(300);
        dog1.swim(350);

        System.out.println("Всего животных: " + Animal.countAnimals);
        System.out.println("Всего котов: " + Cat.countCats);
        System.out.println("Всего собак: " + Dog.countDogs);

        Bowl bowl = new Bowl(50);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Мурзик");
        cats[1] = new Cat("Барсик");
        cats[2] = new Cat("Тузик");
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bowl, 20);
            System.out.println(cats[i].name + " кот сыт? " + cats[i].isFullness);
        }
        System.out.println("Остаток еды в миске: " + bowl.getFood());

        System.out.println("Добавляем еды в миску");
        bowl.addFood(30);
    }
}
