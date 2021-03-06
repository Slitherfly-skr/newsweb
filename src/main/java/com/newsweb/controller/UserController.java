package com.newsweb.controller;

import com.newsweb.entity.Category;
import com.newsweb.entity.News;
import com.newsweb.entity.User;
import com.newsweb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String userLogin(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, Model model, HttpSession session) {
        User user = userService.findUsername(userName,userPassword);
        System.out.println(user);
        if (user == null) {
            model.addAttribute("errMsg","用户名或者密码错误");
            return "login";
        } else {
            session.setAttribute("user", user);
           //return "redirect:/index";
            return "index";
        }
    }

    @RequestMapping("/regist")
    public String regist() {
        return "regist";
    }

    @PostMapping("/regist")
    public String regist(User user,Model model){
        User userExist = userService.findByName(user.getUserName());
        if(userExist != null){
            model.addAttribute("rgi_existmsg","用户已存在，请重新输入！");
            return "regist";
        }
        if (user.getUserName().equals("")){
            model.addAttribute("rgi_namemsg","账户名不能为空");
            return "regist";
        }else if (user.getUserPassword().equals("")){
            model.addAttribute("rgi_pwdmsg","密码不能为空");
            return "regist";
        }
        if (!user.getSex().equals("男") && !user.getSex().equals("女")) {
            System.out.println(user + "性别");
            return "regist";
        }else if (user.getEmail().equals("")){
            model.addAttribute("rgi_emailmsg","邮箱不能为空");
            return "regist";
        }
        if (userService.addUser(user)) {
            model.addAttribute("rgi_msg","注册成功！");
        }
        return null;
    }

    @RequestMapping("/user/usercenter")
    public String usercenter() {
        return "views/user/usercenter";
    }

    @GetMapping("/user/userinformation")
    public String updateuser(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        User k = this.userService.getUserById(user.getUserID());
        model.addAttribute("user",k);
        return "views/user/userinformation";
    }

    @GetMapping("/user/update/{id}")
    public String update(@PathVariable int id,Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        User k = userService.getUserById(id);
        model.addAttribute("user",k);
        return "views/user/update";
    }

    @PostMapping("/user/update")
    public String updateuser(User user,Model model) {
        userService.updateUser(user);
        System.out.println(user);
        System.out.println("修改成功！");
        return "redirect:/user/userinformation";
    }
}


