package org.example.lesson6;
/* Задание 1
Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
Создайте коллекцию, содержащую объекты класса Student.
Следует написать метод, который удаляет студентов со средним баллом < 3,
а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3.
Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.*/

import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setCourse(int course) {
        if (course > 0) {
            this.course = course;
        }
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}
