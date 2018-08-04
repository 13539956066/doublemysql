package com.example.ninemysql.dao;/*
 * Created by ZHANG on 2018/8/1
 */

import com.example.ninemysql.datasource.DatabaseContextHolder;
import com.example.ninemysql.datasource.DatabaseType;
import com.example.ninemysql.domain.Student;
import com.example.ninemysql.domain.User;
import com.example.ninemysql.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private userMapper user;

    public User getUserId(int id){
        //DatabaseContextHolder.setDatabaseType(DatabaseType.test);
        return user.seleteperson(id);
    }

    //通过name查找
    public List<User> seleteper(String name){
        return user.seleteName(name);
    }
    //保存一个记录
    public int sav(Integer id,String name,String password){//尝试传入对象
        return user.saveUser(new User(id,name,password));
    }
    //更新一个记录
    public int upd(int oldid,Integer id,String name,String password){
        return user.modify(new User(oldid,id,name,password));
    }
    //删除一个记录
    public int dele(Integer id) {
        return user.dele(id);
    }
    //查看所有记录
    public List<User> findall(){
        //DatabaseContextHolder.setDatabaseType(DatabaseType.lxy2018);
         return user.findAll();
    }

}
