package com.example.ninemysql.controller;/*
 * Created by ZHANG on 2018/8/3
 */

import com.example.ninemysql.service.StudentService;
import com.example.ninemysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class DeleteController {


    ModelAndView modelAndView;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    //修改页面
    @RequestMapping("/toupdpage")
    public ModelAndView updpage(@RequestParam("updid") Integer id,Map<String,Object> res){
        ModelAndView mv = new ModelAndView();
        res.put("id",id);
        mv.setViewName("updpage");
        return mv;
    }

    //删除数据
    //@Transactional
    @RequestMapping(value = "/deleteName1")
    public String deleteName(@RequestParam("delid")int id,Map<String,Object> res)throws Exception {
     if(studentService.seleteperson(id) == null){
            res.put("error", "student没有这个ID");
     }else if (userService.findById(id) == null) {
            res.put("error", "user没有这个ID");
     }else if ((studentService.delete(id) != 1) || (userService.dele(id) != 1))
       res.put("error","删除失败");

        return "success";
    }

    //增加数据
    @RequestMapping(value = "/savePerson1")
    public String savePerson(@RequestParam("id") int id,
                            @RequestParam("username")String username,
                            @RequestParam("password")String password,
                            @RequestParam("name")String name,
                            @RequestParam("university")String university,Map<String,Object> res){
        if((studentService.seleteperson(id) != null) && (userService.findById(id) != null)) {
            res.put("error", "这个ID已经被占用");
        }else if((studentService.save(id,name,university)!=1)||((userService.sav(id,username,password)!=1)))
            res.put("error","增加数据失败");

            return "success";
    }

    //修改数据
    @RequestMapping(value = "/updaPerson1")
    public String updaPerson1(@RequestParam("oldid") int oldid,
                             @RequestParam("id") int id,
                             @RequestParam("username")String username,
                             @RequestParam("password")String password,
                             @RequestParam("name")String name,
                             @RequestParam("university")String university,Map<String,Object> res){
        if(studentService.seleteperson(id) != null && oldid!=id) {
            res.put("error", "这个ID已经被student占用");
        }else if(userService.findById(id) != null && oldid!=id){
            res.put("error", "这个ID已经被user占用");
        }else if((studentService.update(oldid,id,name,university)!=1)||((userService.upd(oldid,id,username,password)!=1)))
            res.put("error","修改数据失败");

        return "success";
    }

}
