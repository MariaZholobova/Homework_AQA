package org.example.lesson3;
/* Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
времени их работы и стоимости.*/

public class Park {
    String name;

    public Park(String name) {
        this.name = name;
    }

    public static class Attractions {
        String attractionName;
        String openingHours;
        double price;

        public Attractions(String attractionName, String openingHours, double price) {
            this.attractionName = attractionName;
            this.openingHours = openingHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + openingHours);
            System.out.println("Цена: " + price);
            System.out.println();
        }

    }
}
