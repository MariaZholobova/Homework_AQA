package org.example.lesson6;

import java.util.*;

public class Main {
    public static void removeLowGrade(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getAverageGrade() < 3.0) {
                iterator.remove();
            }
        }
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (course == s.getCourse()) {
                System.out.println(s.getName());
            }
        }
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Ирина", "л-115", 1, List.of(5, 5, 4)));
        students.add(new Student("Саша", "л-626", 6, List.of(3, 2, 2)));
        students.add(new Student("Максим", "л-214", 2, List.of(4, 2, 3)));

        System.out.println("Список студентов: ");
        for (Student s : students) {
            System.out.println(s.getName() + " - группа: " + s.getGroup() + ", курс: " + s.getCourse() + ", средний балл: " + s.getAverageGrade());
        }

        removeLowGrade(students);

        promoteStudents(students);

        System.out.println("Список студентов после удаления и перевода: ");
        for (Student s : students) {
            System.out.println(s.getName() + ", курс: " + s.getCourse() + ", средний балл: " + s.getAverageGrade());
        }

        System.out.println("Студенты 2 курса: ");
        printStudents(students, 2);

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
