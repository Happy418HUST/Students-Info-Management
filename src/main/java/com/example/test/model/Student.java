package com.example.test.model;

import java.sql.Date;

public class Student {
    private String id;
    private String password;
    private String name;
    private int age;
    private String major;
    private Date joinDate;
    private int state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public Date getJoinDate() {
        return joinDate;
    }

    public void setAddDate(Date addDate) {
        this.joinDate = addDate;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age
                + ", joinDate=" + joinDate + ", state=" + state + "]";
    }

}
