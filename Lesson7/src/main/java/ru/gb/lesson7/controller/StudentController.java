package ru.gb.lesson7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.lesson7.entities.Student;
import ru.gb.lesson7.services.StudentService;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = service.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/add")
    public String showAddStudentForm(Student student) {
        return "add-student";
    }

    @PostMapping("/students/add")
    public String addStudent(Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }

        service.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable("id") long id, Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "update-student";
        }

        service.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}

