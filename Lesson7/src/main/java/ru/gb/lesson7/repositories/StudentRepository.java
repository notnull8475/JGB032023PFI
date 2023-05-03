package ru.gb.lesson7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson7.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
