package com.example.ninemysql.service;/*
 * Created by ZHANG on 2018/8/1
 */

import com.example.ninemysql.dao.UserDao;
import com.example.ninemysql.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> AllUser(){
        return userDao.findall();
    }

    public User findById(int id){
        return userDao.getUserId(id);
    }

    public List<User> findByName(String name){
        return userDao.seleteper(name);
    }

    public int sav(int id,String name,String password){
        return userDao.sav(id,name,password);
    }

    public int upd(int oldid,int id,String name,String password){
        return userDao.upd(oldid,id,name,password);
    }

    public int dele(int id){
        return userDao.dele(id);
    }
}
