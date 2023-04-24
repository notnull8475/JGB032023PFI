package ru.gb.utils;

import ru.gb.dao.StudentDAO;
import ru.gb.entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FillTable {
    public static void fillTable() {
        List<Student> students = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            String name = "Student " + i;
            int mark = random.nextInt(101);
            Student student = new Student(name, mark);
            students.add(student);
        }
// Добавляем студентов в БД
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudents(students);
    }
}
