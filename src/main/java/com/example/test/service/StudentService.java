package com.example.test.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import com.example.test.model.Student;


@Mapper
public interface StudentService {
    @Select("SELECT * FROM STUDENTSMANAGEMENT.Student WHERE ID = #{id};")
    List<Student> findById(Student studen);

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

    @Select("SELECT * FROM STUDENTSMANAGEMENT.Student WHERE name = #{name};")
    List<Student> findByname(Student student);

    @Select("SELECT * FROM STUDENTSMANAGEMENT.Student WHERE major = #{major};")
    List<Student> findBymajor(Student student);

    @Select("SELECT * FROM STUDENTSMANAGEMENT.Student WHERE name = #{name} AND major = #{major};")
    List<Student> findByall(Student student);

    @Insert("INSERT INTO `STUDENTSMANAGEMENT`.`STUDENT` (`id`, `password`,`name`,`major`,`joinDate`, `state`) VALUES (#{id}, 1234,#{name}, #{major}, #{joinDate} ,1);")
    int insert(Student student);

    @Update("UPDATE `STUDENTSMANAGEMENT`.`STUDENT` SET `name` = #{name},`major` = #{major},`joinDate` = #{joinDate}  WHERE `id` = #{id} ;")
    int editById(Student student);

    @Delete("DELETE FROM `STUDENTSMANAGEMENT`.`STUDENT`  WHERE `id` = #{id} ;")
    int deleteById(Student student);

}
