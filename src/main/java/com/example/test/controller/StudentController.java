package com.example.test.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.test.model.Student;
import com.example.test.service.StudentService;
import java.util.List;
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

//  主界面跳转
    @RequestMapping("/index")
    public String gotoIndex(Student student,Model model) {
        return "index";
    }

//主界面传值
    @GetMapping("/index/data")
    @ResponseBody
    public List<Student> showStudents(Student student,Model model) {
        List<Student> studentList = studentService.list(student);
        //输出
        model.addAttribute("studentList", studentList);
        model.addAttribute("student",student);
        return studentList;
    }
    @PostMapping("/index/add")
    public String addStudent(Student student,Model model){
        studentService.insert(student);
        return "redirect:";
    }
}