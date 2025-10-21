package org.example.lesson3;
/* Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
времени их работы и стоимости.*/

public class Park {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    public void printInfoPark() {
        System.out.println("Парк: " + name);
    }


    public class Attractions {
        private String attractionName;
        private String openingHours;
        private double price;

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
