package com.example.test.controller;
import jdk.nashorn.internal.objects.NativeJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.InitBinder;
import com.example.test.model.Student;
import com.example.test.service.StudentService;

import javax.servlet.http.HttpSession;
import java.io.Console;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

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
        return studentList;
    }
    @RequestMapping("/select")
    @ResponseBody
    public Map<String,Object> select(Student student, Model model, HttpSession httpSession){
        System.out.println("select!!!!!");
        System.out.println(student.getName());
        System.out.println(student.getMajor());
        List<Student> studentList = null;
        Map<String,Object> map=new HashMap<String, Object>();
        if(student.getName()== ""){
            System.out.println("student.getName()== null");
            if(student.getMajor()== ""){System.out.println("both empty");
            studentList = studentService.list(student);
            }
            else{studentList = studentService.findBymajor(student);
                System.out.println("major only");}
        }
        else
        {
            if(student.getMajor()== ""){
                System.out.println("只有名字");
                studentList = studentService.findByname(student);}
            else{
                System.out.println("both ");
                studentList = studentService.findByall(student);}
        }
        map.put("selectresult", studentList);
        return map;
    }


    @PostMapping("/add")
    public String addStudent(Student student,Model model){
        studentService.insert(student);
        return "redirect:index";
    }


    @PostMapping("/delete")
    public String deleteStudents(Student student,Model model){
        studentService.deleteById(student);
        return "redirect:index";
    }

    @PostMapping("/edit")
    public String editStudent(Student student,Model model){
        studentService.editById(student);
        return "redirect:index";
    }

}