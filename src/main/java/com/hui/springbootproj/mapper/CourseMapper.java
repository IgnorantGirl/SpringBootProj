package com.hui.springbootproj.mapper;

import com.hui.springbootproj.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {
    List<Course> queryAllUser();

}
