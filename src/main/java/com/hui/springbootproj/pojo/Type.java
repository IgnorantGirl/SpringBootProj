package com.hui.springbootproj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Type {
    private Long id;
    private String name;
    private List<Blog> blogs = new ArrayList<>();

}
