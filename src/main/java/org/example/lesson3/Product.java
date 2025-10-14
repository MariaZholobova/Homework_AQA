package org.example.lesson3;
/*1. Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения,
цена, состояние бронирования покупателем.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.*/

public class Product {
    String name;
    String productionDate;
    String producer;
    String country;
    double price;
    boolean status;

    public Product(String name, String productionDate, String producer, String country, double price, boolean status) {
        this.name = name;
        this.productionDate = productionDate;
        this.producer = producer;
        this.country = country;
        this.price = price;
        this.status = status;
    }

    public void printProduct() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + producer);
        System.out.println("Страна: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Забронирован: " + (status ? "Да" : "Нет"));
        System.out.println();
    }
}
