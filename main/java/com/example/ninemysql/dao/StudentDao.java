package com.example.ninemysql.dao;/*
 * Created by ZHANG on 2018/8/1
 */

import com.example.ninemysql.datasource.DatabaseContextHolder;
import com.example.ninemysql.datasource.DatabaseType;
import com.example.ninemysql.domain.Student;
import com.example.ninemysql.mapper.studentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    private studentMapper student;
    //通过id查找
    public Student seleteById(int id){
        return student.seleteid(id);
    }
    //通过name查找
    /*public List<Student> seleteper(String name){
        return student.seleteperson(name);
    }*/
    //通过university查找
    /*public List<Student> seleteuniversity(String university){
        return student.seleteuniversity(university);
    }*/
    //查找name和university条件
    public List<Student> seledouble(String name,String university){
        if(name == null)
            name = "";
        if(university == null)
            university = "";
        return student.seletedouble(new Student(name,university));
    }
    //保存一个记录
    public int sav(int id,String name,String university){//尝试传入对象
        Student stu = new Student(id,name,university);
        return student.saveUser(stu);
    }
    //更新一个记录
    public int upd(int oldid,int id,String name,String university){
        return student.modify(new Student(oldid,id,name,university));
    }
    //删除一个记录
    public int deleStu(int id) {
        return student.dele(id);
    }
    //查看所有记录
    public List<Student> findall(){
        //DatabaseContextHolder.setDatabaseType(DatabaseType.lxy2018);
        return student.findAll();
    }

}
