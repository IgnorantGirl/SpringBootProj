package com.hui.springbootproj;

import com.hui.springbootproj.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestUserController {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception{
        // 测试UserController
        RequestBuilder request = null;
        // 1.get user列表， 返回应该为null
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2.post提交一个user
        request = post("/users/")
                .param("id", "1")
                .param("name", "测试大师")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("Success")));

        // 3.get获取user列表
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

        // 4.修改
        request = put("/users/1/")
                .param("name", "测试中级大师")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string(equalTo("Success")));

        // 5,获取id为1的user
        request = get("/users/1/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试中级大师\",\"age\":30}")));

        // 6.del删除id为1的user
        request = delete("/users/1/");
        mvc.perform(request)
                .andExpect(content().string(equalTo("Success")));
        // 7.get user列表
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void TestspringVersionAndspringBootVersion (){
        String springVersion = SpringVersion.getVersion();
        System.out.println(springVersion);
        String springBootVersion = SpringBootVersion.getVersion();
        System.out.println(springBootVersion);
    }
}
