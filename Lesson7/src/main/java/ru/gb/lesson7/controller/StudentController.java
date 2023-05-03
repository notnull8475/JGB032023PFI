package ru.gb.lesson7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson7.entities.Student;
import ru.gb.lesson7.services.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("studentList", service.getAllStudents());
        return "students";
    }

    @GetMapping("/{id}")
//    @ResponseBody
    public String getStudent(@PathVariable int id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "student";
    }
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/add")
    public String create(Student student) {
        service.addStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/edit")
    public String update(Student student){
        service.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        service.deleteStudent(id);
        return "redirect:/students";
    }
}

