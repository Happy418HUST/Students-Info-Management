package com.example.test.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Student {
    private String id;
    private String password;
    private String name;
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

    public Date getJoinDate() {
        System.out.println("getJoinDate :" + joinDate);
        return joinDate;
    }

    public void setJoinDate(String joinDate) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(joinDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
//        System.out.println("********************************");
//        System.out.println(joinDate);
//        System.out.println(date);
//        System.out.println("********************************");
        System.out.println("setJoinDate:   String:"+joinDate + "   Date :" + date);
        this.joinDate = date;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", password=" + password
                +", major=" + major
                + ", joinDate=" + joinDate + ", state=" + state + "]";
    }

}
