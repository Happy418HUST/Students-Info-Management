package com.example.test.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.test.model.Admin;

@Mapper   //   mapper似乎是一个myBaits 注解，表示将java方法和sql操作映射起来
public interface AdminService {
    //sql语句里的用井号和花括号括起来的参数，对应实体类里的各个同名属性
    //例如#{userName}  对应了    参数admin对象的userName属性
    @Select("SELECT * FROM `studentsManagement`.`admin` where userName = #{userName} and password = #{password} ;")
    Admin findByNameAndPassword(Admin admin);

    @Select("SELECT * FROM `studentsmMnagement`.`admin` where userName = #{userName} and password = #{password} and realName = #{realName}")
    List<Admin> findByAdminWithPage(Admin admin, int start, int end);

    @Insert("INSERT INTO `studentsManagement`.`admin` (`id`, `userName`, `password`, `realName`, `age`, `phoneNumber`, `headPicture`, `addDate`, `updateDate`, `state`) VALUES (null, #{userName}, #{password}, #{realName}, #{age}, #{phoneNumber}, #{headPicture}, now(), now(), 0);")
    int insert(Admin admin);

    @Update("UPDATE `studentsManagement`.`admin` SET `userName` = #{userName}, `password` = #{password}, `realName` = #{realName}, `age` = #{age}, `phoneNumber` = #{phoneNumber}, `headPicture` = #{headPicture}, `updateDate` = now(), `state` = #{state} WHERE `id` = #{id};")
    int updateStateById(int id);

    @Delete("DELETE FROM `studentsManagement`.`admin` WHERE id  = #{id}")
    int deleteById(int id);
}

