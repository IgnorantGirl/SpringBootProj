package com.hui.springbootproj.web;

import com.hui.springbootproj.mapper.CourseMapper;
import com.hui.springbootproj.pojo.Course;
import com.hui.springbootproj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private CourseMapper courseMapper;

    @RequestMapping("/querycourse")
    public List<Course> queryAllUser(){
        return courseMapper.queryAllUser();
    }


    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(value = "/",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<User> getUserList(){
        List<User> r = new ArrayList<>(users.values());
        return r;
    };
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId(),user);
        return "Success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public User getUser(@PathVariable Long id){
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return  users.get(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user){
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "Success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "Success";
    }
}
