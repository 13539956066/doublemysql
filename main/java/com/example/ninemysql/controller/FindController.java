package com.example.ninemysql.controller;/*
 * Created by ZHANG on 2018/8/2
 */

import com.example.ninemysql.domain.Student;
import com.example.ninemysql.domain.User;
import com.example.ninemysql.service.StudentService;
import com.example.ninemysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FindController {

    ModelAndView modelAndView;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    //主页
    @RequestMapping("/aaa")
    public ModelAndView insert(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.html");
        return mv;
    }

    //查看综合数据
    @RequestMapping(value = "/ifindAll")
    public String find1All(Map<String,Object> res){
        List<Student> list1 =studentService.find1all();
        List<User> list2 = userService.AllUser();
        List<Object> reslist = new ArrayList<>();
       for(Student student:list1){
           for(User user:list2){
              if(student.getId() == user.getId()) {
                  Map<String,Object> context = new HashMap<>();
                  context.put("id",user.getId());
                  context.put("name", student.getName());
                  context.put("username",user.getUsername());
                  context.put("password",user.getPassword());
                  context.put("university",student.getUniversity());
                  reslist.add(context);
                  //System.out.println(reslist);
              }
           }
       }
        res.put("listres",reslist);
        return "a";
    }

    //筛选name,username,university找到符合的记录
    @RequestMapping(value = "/findmore")
    public String findmore(HttpServletRequest request,Map<String, Object> res){
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String university = request.getParameter("university");

        List<Object> reslist = new ArrayList<>();
        List<Student> Studentlist = studentService.seleteDouble(name,university);
        List<User> Userlist = userService.findByName(username);
        //返回错误信息
        if((Userlist.size()==0) && (Studentlist.size()==0)) {
            res.put("error", "没有这个数据");
            return "success";
        }else{
            for(Student student : Studentlist){
                for(User user:Userlist)
                    if(user.getId() == student.getId())
                        reslist.addAll(mapput(student,user));
            }
        }
        if(reslist.size() == 0) {
            res.put("error", "没有这个数据");
            return "success";
        }
        res.put("listres",reslist);
        return "a";
    }

    //查看符合该id的记录
    @RequestMapping(value = "/seletePersonId1")
    public String seletePerson(@RequestParam("id")int id,Map<String,Object> res){
        Student s=studentService.seleteperson(id);
        User user = userService.findById(id);
        List<Object> result = new ArrayList<>();
        //返回错误信息
        if(s!= null && user != null){
            /*return "找到id是 "+id+" 的数据为"+"..username:"+user.getUsername()+"..password:"+user.getPassword()
                    +"..name:"+s.getName()+"..university:"+s.getUniversity();*/
            result.addAll(mapput(s,user));
        }else {
            res.put("error", "没有这个数据");
            return "success";
        }
        res.put("findid",id);
        res.put("listres",result);
        return "a";
    }


    //模糊搜索符合username的记录
    @RequestMapping(value = "/findByname1")
    public String findByname(@RequestParam("username")String username,Map<String,Object> res){
        List<User> userlist = userService.findByName(username);
        List<Object> result = new ArrayList<>();
        //返回错误信息
        if(userlist.size() == 0){
            res.put("error", "没有这个数据");
            return "success";
        }else {
            for (User user : userlist) {
                int id = user.getId();
                Student s = studentService.seleteperson(id);
                result.addAll(mapput(s, user));
                /*return "找到username是 "+username+" 的数据为"+"..password:"+user.getPassword()
                        +"..name:"+s.getName()+"..university:"+s.getUniversity();*/
            }
        }
        res.put("findname", username);
        res.put("listres",result);
        return "a";
    }

    //将返回数据打包
    public List<Object> mapput(Student student,User user){
        Map<String,Object> context = new HashMap<>();
        context.put("id",user.getId());
        context.put("name", student.getName());
        context.put("username",user.getUsername());
        context.put("password",user.getPassword());
        context.put("university",student.getUniversity());
        List<Object>  list = new ArrayList<>();
        list.add(context);
        return list;
        //result.put("listres",list);
        //return result;
    }
}
//模糊搜索符合name的记录
    /*@RequestMapping(value = "/seletePerson1")
    public String seletePerson(@RequestParam("name")String name,Map<String,Object> res){
        List<Student> student1= studentService.seleteperson(name);
        List<Object> result = new ArrayList<>();
        for(Student student:student1){
            int id = student.getId();
            User user = userService.findById(id);
            result.addAll(mapput(student, user));
                *//*return "找到name是 "+name+" 的数据为"+"..id:"+s.getId()+"..username:"+user.getUsername()
                        +"..password:"+user.getPassword()+"..university:"+s.getUniversity();*//*
            }
        res.put("findname", name);
        res.put("listres",result);
        return "a";
    }

    //模糊搜索符合university的记录
    @RequestMapping(value = "/seleteUniversity")
    public String seleteUniversity(@RequestParam("university")String university,Map<String,Object> res){
        List<Student> student1= studentService.seleteStuuniversity(university);
        List<Object> result = new ArrayList<>();
        for(Student student : student1) {
            int id = student.getId();
            User user = userService.findById(id);
               *//* return "找到university是 "+university+" 的数据为"+"..id:"+s.getId()
                        +"..username:"+user.getUsername()+"..password:"+user.getPassword()+"..name:"+s.getName();*//*
                result.addAll(mapput(student, user));
        }
        res.put("finduniversity", university);
        res.put("listres",result);
        return "a";
    }*/
