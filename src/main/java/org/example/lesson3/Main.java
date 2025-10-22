package org.example.lesson3;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Майка", "01.05.2025", "Ивановские товары", "Россия", 1200, true);
        Product p2 = new Product("Платье", "05.05.2025", "Белорусские товары", "Беларусь", 5200, false);
        p1.printProduct();
        p2.printProduct();

        /* Создать массив из 5 товаров. */

        Product[] productArray = new Product[5];
        productArray[0] = new Product("Майка", "01.05.2025", "Ивановские товары", "Россия", 1200, true);
        productArray[1] = new Product("Платье", "05.05.2025", "Белорусские товары", "Беларусь", 5200, false);
        productArray[2] = new Product("Шорты", "05.05.2024", "Москвичка", "Россия", 1500, false);
        productArray[3] = new Product("Брюки", "01.05.2023", "Москвичка", "Россия", 4500, true);
        productArray[4] = new Product("Сапоги", "10.09.2025", "Лель", "Россия", 9800, true);
        for (int i = 0; i < productArray.length; i++) {
            productArray[i].printProduct();
        }

        Park park = new Park("Городской парк", 5);

        Park.Attractions rollerCoaster = park.new Attractions("Американские горки", "9:00 - 18:00", 150);
        Park.Attractions ferrisWheel = park.new Attractions("Колесо обозрения", "10:00 - 17:00", 300.50);

        park.addAttraction(rollerCoaster);
        park.addAttraction(ferrisWheel);
        park.printInfoPark();


    }
}
