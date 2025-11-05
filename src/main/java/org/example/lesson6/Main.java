package org.example.lesson6;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Ирина", "л-115", 1, List.of(5, 5, 4)));
        students.add(new Student("Саша", "л-626", 6, List.of(3, 2, 2)));
        students.add(new Student("Максим", "л-214", 2, List.of(4, 2, 3)));

        StudentManager manager = new StudentManager(students);

        System.out.println("Список студентов: ");
        manager.printAllStudents();

        manager.removeLowGrade();

        manager.promoteStudents();

        System.out.println("Список студентов после удаления и перевода: ");
        manager.printAllStudents();


        System.out.println("Студенты 2 курса: ");
        manager.printStudents(2);

        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("Ivanov", "+79229221234");
        phoneDirectory.add("Ivanov", "+79229231234");
        phoneDirectory.add("Petrov", "+79229241234");
        phoneDirectory.add("Smirnov", "+79229251234");

        System.out.println("Телефоны Иванова: " + phoneDirectory.get("Ivanov"));
        System.out.println("Телефоны Петрова: " + phoneDirectory.get("Petrov"));

        phoneDirectory.add("Petrov", "+79229241235");

        System.out.println("Телефоны Петрова: " + phoneDirectory.get("Petrov"));
    }
}
