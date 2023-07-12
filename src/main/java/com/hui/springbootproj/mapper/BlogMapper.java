package com.hui.springbootproj.mapper;

import com.hui.springbootproj.pojo.Blog;
import com.hui.springbootproj.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {

    List<Blog> queryAllBlog();

}
