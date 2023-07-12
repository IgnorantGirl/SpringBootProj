package com.hui.springbootproj.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogController {

    //跳转[博客列表]页面
    @GetMapping("/blogs")
    public String blogs(){
//        if (pageNum==null){
//            pageNum = 1;
//        }
//        PageInfo<Blog> pageInfo = blogService.pageAdminBlogs(pageNum, 6);
//        model.addAttribute("page",pageInfo);

        return "admin/index";
    }
}
