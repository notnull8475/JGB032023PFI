package ru.gb.lesson7.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.gb.lesson7.entities.Student;
import ru.gb.lesson7.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }


    public void addStudent(Student student) {
        repository.save(student);
    }

    public Student getStudentById(long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public void updateStudent(Student student) {
        repository.save(student);
    }

    public void deleteStudent(long id) {
        repository.deleteById(id);
    }
}
