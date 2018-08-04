package com.example.ninemysql.mapper;/*
 * Created by ZHANG on 2018/7/23
 */

import com.example.ninemysql.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userMapper {
//数据库操作放这里
    public List<User> findAll();
    public User seleteperson(Integer id);
    public List<User> seleteName(String name);
    public int saveUser(User user);
    public int modify(User user);
    public int dele(Integer id) ;
}
