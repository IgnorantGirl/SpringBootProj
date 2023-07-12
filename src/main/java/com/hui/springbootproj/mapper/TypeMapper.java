package com.hui.springbootproj.mapper;

import com.hui.springbootproj.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {
    Type getTypeByName(String name);

    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    int updateType(Type type);

    void deleteType(Long id);

    List<Type> getAllTypeAndBlog();
}
