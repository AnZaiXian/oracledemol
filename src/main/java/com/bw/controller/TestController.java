package com.bw.controller;

import com.bw.bean.Teacher;
import com.bw.repostory.TeacherRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/8/1.
 */
@Controller
public class TestController {


    //创建teacher的实例
   @Autowired
   private TeacherRepostory teacherRepostory;

    /**
     * 到添加学生的页面
     */
     @RequestMapping("regiter")
     public String tologin(){

         return "regiter";
     }

    /**
     * 用户注册
     */
    @RequestMapping("add")
    public  String addUser(Teacher teacher){
        System.out.println(teacher);
        teacherRepostory.save(teacher);
        return "login";
    }

    /**
     * 用户登录
     */
    @RequestMapping("login")
    public  String login(Teacher teacher){
        System.out.println(teacher);
        teacherRepostory.findAllByNameAndPwd(teacher.getName(),teacher.getPwd());
        return "redirect:showUser";
    }


    /**
     * 查询用户信息
     */
    @RequestMapping("showUser")
    public  String showUser(Map<String ,Object> map){
        List<Teacher> all = teacherRepostory.findAll();
        for (Teacher t: all){
            System.out.println(t);
        }
        map.put("list",all);
        return "showUser";
    }


    /**
     * deleteUser删除用户
     */
    @RequestMapping("deleteUser")
    public  String deleteUser(Integer id){
        teacherRepostory.delete(id);
        return "redirect:showUser";
    }

    /**
     * 根据id查询对象
     */
    @RequestMapping("hxFriends")
    @ResponseBody
    public  Teacher hxFriends(Integer id){
        Teacher one = teacherRepostory.findOne(id);

        return one;
    }


    /**
     * 修改用户信息
     * @param teacher
     * @return
     */
    @RequestMapping("updateUser")
    public  String updateUser(Teacher teacher){
        System.out.println(teacher);
        teacherRepostory.modifyById(teacher.getName(),teacher.getPwd(),teacher.getId());
        return "redirect:showUser";
    }




}
