package com.hui.springbootproj.controller.admin;


import com.hui.springbootproj.mapper.UserMapper;
import com.hui.springbootproj.pojo.User;
import com.hui.springbootproj.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/",""})
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes){
        User user = userService.checkUser(username, password);
        if(user !=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            // 设置session永不过期
            session.setMaxInactiveInterval(-1);
            return "admin/index";
        }else{
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }


    /**
     * @Description: 注销
     * @Return: 返回登录页面
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
