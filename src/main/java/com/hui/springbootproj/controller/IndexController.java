package com.hui.springbootproj.controller;


import com.hui.springbootproj.mapper.BlogMapper;
import com.hui.springbootproj.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/blogs")
public class IndexController {

    @Autowired
    private BlogMapper blogMapper;

    @RequestMapping("/queryblog")
    public List<Blog> queryAllBlog(){
        return blogMapper.queryAllBlog();
    }


}
