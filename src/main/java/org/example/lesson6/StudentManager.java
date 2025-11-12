package org.example.lesson6;

import java.util.Iterator;
import java.util.Set;

public class StudentManager {
    private Set<Student> students;

    public StudentManager(Set<Student> students) {
        this.students = students;
    }

    public void printAllStudents() {
        for (Student s : students) {
            System.out.println(s.getName() + " - группа: " + s.getGroup() + ", курс: " + s.getCourse() + ", средний балл: " + s.getAverageGrade());
        }
    }

    public void removeLowGrade() {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getAverageGrade() < 3.0) {
                iterator.remove();
            }
        }
    }

    public void promoteStudents() {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public void printStudents(int course) {
        for (Student s : students) {
            if (course == s.getCourse()) {
                System.out.println(s.getName());
            }
        }
    }
}
