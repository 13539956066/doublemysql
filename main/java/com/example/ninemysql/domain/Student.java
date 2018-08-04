package com.example.ninemysql.domain;/*
 * Created by ZHANG on 2018/8/2
 */

public class Student {
    private int oldid;
    private int id;
    private String name;
    private String university;

    public Student(){
    }
    public Student(int id,String name,String university){
        this.id = id;
        this.name = name;
        this.university = university;
    }
    public Student(String name,String university){
        this.name = name;
        this.university = university;
    }
    //为修改做的构造函数
    public Student(int oldid,int id,String name,String university){
        this.oldid = oldid;
        this.id = id;
        this.name = name;
        this.university = university;
    }

    public int getOldid() {
        return oldid;
    }

    public void setOldid(int oldid) {
        this.oldid = oldid;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString(){
        return "{student:  "+
                "id..."+id+
                "name..."+name+
                "university..."+university
                +"}";
    }
}
