package com.hui.springbootproj.controller;

import com.hui.springbootproj.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {


    @GetMapping("/")
    public String index() {
//        int i=9/0;   //自定义到500

//        //博客找不到了
//        String blog = null;
//        if(blog == null){
//           // throw new NotFoundException("博客不存在");
//        }
        return "index";
    }
}