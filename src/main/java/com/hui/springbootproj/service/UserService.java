package com.hui.springbootproj.service;


import com.hui.springbootproj.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService  {
    /**
     * 根据username和password查找用户
     */
    User checkUser(String username,String password);

}
