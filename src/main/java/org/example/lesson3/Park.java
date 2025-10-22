package org.example.lesson3;
/* Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
времени их работы и стоимости.*/

public class Park {
    private String name;
    private Attractions[] attractions;
    private int count;

    public Park(String name, int capacity) {
        this.name = name;
        this.attractions = new Attractions[capacity];
        this.count = 0;
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

    public void addAttraction(Attractions attraction) {
        if (count < attractions.length) {
            attractions[count] = attraction;
            count++;
        } else {
            System.out.println("Нельзя добавить больше аттракционов — парк заполнен");
        }
    }


    public void printInfoPark() {
        System.out.println("Парк: " + name);
        System.out.println("Аттракционы в парке: ");
        for (int i = 0; i < count; i++) {
            attractions[i].printInfo();
        }
    }
}
