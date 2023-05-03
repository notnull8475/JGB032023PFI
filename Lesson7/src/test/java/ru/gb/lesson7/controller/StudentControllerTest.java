package ru.gb.lesson7.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.gb.lesson7.entities.Student;
import ru.gb.lesson7.services.StudentService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testGetAllStudents() throws Exception {
        List<Student> students = Arrays.asList(
                new Student(1L,"John Doe", 20),
                new Student(2L,"Jane Doe", 22)
        );

        when(studentService.getAllStudents()).thenReturn(students);

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(view().name("students"));
//                .andExpect(model().attribute("students", students));
    }

    @Test
    public void testGetAddStudentForm() throws Exception {
        mockMvc.perform(get("/students/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-student"))
                .andExpect(model().attributeExists("student"));
    }

    @Test
    public void testAddStudent() throws Exception {
        Student student = new Student("John Doe", 20);

        mockMvc.perform(post("/students/add")
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", student.getName())
                        .param("age", String.valueOf(student.getAge())))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/students"));

        verify(studentService, times(1)).addStudent(student);
    }

    @Test
    public void testGetUpdateStudentForm() throws Exception {
        Student student = new Student(1L,"John Doe", 20);

        when(studentService.getStudentById(student.getId())).thenReturn(student);

        mockMvc.perform(get("/students/edit", student.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("update-student"))
                .andExpect(model().attribute("student", student));
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Student student = new Student("John Doe", 20);

        mockMvc.perform(post("/students/update/{id}", student.getId())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", String.valueOf(student.getId()))
                        .param("name", "Jane Doe")
                        .param("age", "22"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/students"));

        Student student1 = new Student("Jane Doe", 22);
        student1.setId(student.getId());
        verify(studentService, times(1)).updateStudent(student1);
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Long id = 1L;

        mockMvc.perform(get("/students/delete/{id}", id))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/students"));

        verify(studentService, times(1)).deleteStudent(id);
    }
}
