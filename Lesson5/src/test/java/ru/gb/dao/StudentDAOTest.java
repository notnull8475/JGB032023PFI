package ru.gb.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.gb.entities.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {
    private static SessionFactory sessionFactory;
    private static StudentDAO studentDAO;

    @BeforeAll
    public static void setup() {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class);
        sessionFactory = configuration.buildSessionFactory();
        studentDAO = new StudentDAO();
    }

    @AfterAll
    public static void cleanup() {
        sessionFactory.close();
    }

    @Test
    public void testAddAndGetStudent() {
        // Добавляем студента
        Student student = new Student("John Doe", 80);
        studentDAO.addStudent(student);

        // Получаем студента по ID
        Student retrievedStudent = studentDAO.getStudentById(student.getId());
        assertNotNull(retrievedStudent);

        // Проверяем соответствие данных
        assertEquals(student.getName(), retrievedStudent.getName());
        assertEquals(student.getMark(), retrievedStudent.getMark());
    }

    @Test
    public void testUpdateStudent() {
        // Добавляем студента
        Student student = new Student("Jane Smith", 75);
        studentDAO.addStudent(student);

        // Изменяем оценку студента
        student.setMark(90);
        studentDAO.updateStudent(student);

        // Получаем студента по ID
        Student retrievedStudent = studentDAO.getStudentById(student.getId());
        assertNotNull(retrievedStudent);

        // Проверяем соответствие данных
        assertEquals(student.getName(), retrievedStudent.getName());
        assertEquals(student.getMark(), retrievedStudent.getMark());
    }

    @Test
    public void testDeleteStudent() {
        // Добавляем студента
        Student student = new Student("Bob Johnson", 60);
        studentDAO.addStudent(student);

        // Удаляем студента
        studentDAO.deleteStudent(student);

        // Получаем студента по ID
        Student retrievedStudent = studentDAO.getStudentById(student.getId());
        assertNull(retrievedStudent);
    }

    @Test
    public void testGetAllStudents() {
        // Добавляем несколько студентов
        int fs = studentDAO.getAllStudents().size();
        studentDAO.addStudent(new Student("Jane Smith", 75));
        studentDAO.addStudent(new Student("Jane 1", 80));
        studentDAO.addStudent(new Student("Jane 2", 85));

        assertEquals(fs + 3, studentDAO.getAllStudents().size());
    }

}