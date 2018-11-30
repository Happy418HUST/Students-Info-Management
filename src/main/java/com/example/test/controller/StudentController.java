package com.example.test.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.test.model.Student;
import com.example.test.service.StudentService;
import java.util.List;
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/index")
    public String showStudents(Student student,Model model) {
        List<Student> studentList = studentService.list(student);
        //输出
        model.addAttribute("studentList", studentList);
        model.addAttribute("student",student);
        return "index";
    }
}