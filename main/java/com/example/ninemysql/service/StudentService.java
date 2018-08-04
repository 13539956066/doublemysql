package com.example.ninemysql.service;/*
 * Created by ZHANG on 2018/8/1
 */

import com.example.ninemysql.dao.StudentDao;
import com.example.ninemysql.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("User1Service")
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> find1all(){
        return studentDao.findall();
    }

    /*public List<Student> seleteperson(String name){
        return studentDao.seleteper(name);
    }*/

    public Student seleteperson(int id){
        return studentDao.seleteById(id);
    }

    /*public List<Student> seleteStuuniversity(String university){
        return studentDao.seleteuniversity(university);
    }*/

    //查找符合name和university的记录,可以有空值
    public List<Student> seleteDouble(String name,String university){
        return studentDao.seledouble(name,university);
    }


    public int save(int id,String name,String university){
        return studentDao.sav(id,name,university);
    }

    public int update(int oldid,int id,String name,String university){
        return studentDao.upd(oldid,id,name,university);
    }

    public int delete(int id){
        return studentDao.deleStu(id);
    }
}
