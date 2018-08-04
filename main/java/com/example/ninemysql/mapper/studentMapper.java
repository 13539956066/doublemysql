package com.example.ninemysql.mapper;/*
 * Created by ZHANG on 2018/7/30
 */
import com.example.ninemysql.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface studentMapper {

    public List<Student> findAll();
    public Student seleteid(int id);
    //public List<Student> seleteperson(String name);
    //public List<Student> seleteuniversity(String university);
    public List<Student> seletedouble(Student student);
    public int saveUser(Student student);
    public int modify(Student student);//String name,String university
    public int dele(int id) ;
}
