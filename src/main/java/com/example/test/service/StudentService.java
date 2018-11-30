package com.example.test.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.test.model.Student;


@Mapper
public interface StudentService {

    @Select("SELECT * FROM STUDENTSMANAGEMENT.Student WHERE ID = #{id};")
    Student findById(Student studen);

    @Select({
            "SELECT * FROM STUDENTSMANAGEMENT.STUDENT ",
            "WHERE STATE = 1 ;",
    })
    List<Student> list(Student student);

    @Select({
            "SELECT COUNT(*) FROM STUDENTSMANAGEMENT.STUDENT N ",
            "WHERE N.STATE = 1 ;",
    })
    int count(Student student);


}
