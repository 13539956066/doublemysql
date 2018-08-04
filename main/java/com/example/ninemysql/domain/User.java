package com.example.ninemysql.domain;/*
 * Created by ZHANG on 2018/7/31
 */
public class User {
    private int oldid;
    private int id;
    private String username;
    private String password;

    public User(){
    }
    public User(int id,String username,String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public User(int oldid,int id,String username,String password){
        this.oldid = oldid;
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "{User:  "+
                "id..."+id+
                "name..."+username+
                "password..."+password+
                "}";

    }
}
