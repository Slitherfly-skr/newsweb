package com.newsweb.controller;

import com.newsweb.entity.Admin;
import com.newsweb.entity.Category;
import com.newsweb.entity.News;
import com.newsweb.entity.User;
import com.newsweb.service.CategoryService;
import com.newsweb.service.impl.AdminServiceImpl;
import com.newsweb.service.impl.CommentServiceImpl;
import com.newsweb.service.impl.NewsServiceImpl;
import com.newsweb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private NewsServiceImpl newsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentServiceImpl commentService;

    //@GetMapping(value={"/adminlogin","/"})
    @GetMapping(value={"/adminlogin"})
    public String adminlogin(){
        return "adminlogin";
    }

    @PostMapping(value={"/adminlogin"})
    public String adminlogin(Admin admin, Model model, HttpServletRequest request){
        Admin u = this.adminService.login(admin);
        if(u==null){
            model.addAttribute("errMsg","用户名或者密码错误");
            return "adminlogin";
        }

        request.getSession().setAttribute("loginAdmin",u);

        //return "redirect:/adminindex";
        return  "adminindex";
    }

//    @GetMapping("/adminindex")
//    public String adminindex(HttpServletRequest request,Model model){
//        if(request.getSession().getAttribute("loginAdmin")==null){
//            model.addAttribute("errMsg","请登陆系统");
//            return "adminlogin";
//        }
//        return "adminindex";
//    }
    //查看用户列表
    @GetMapping("/user/list")
    public String userlist(Model model){
        List<User> list = userService.getAll();
        model.addAttribute("list",list);
        return "views/user/list";
    }
    //删除用户
    @GetMapping("/user/del/{id}")
    public String del(@PathVariable int id){
        this.userService.delUser(id);
        this.commentService.delUserComment(id);
        return "redirect:/user/list";
    }

    //查看新闻列表
    @GetMapping("/news/list")
    public String newslist(Model model){
        List<News> list = newsService.getAll();
        model.addAttribute("list",list);
        return "views/news/list";
    }

    //删除新闻
    @GetMapping("/news/del/{id}")
    public String newsdel(@PathVariable int id){
        this.newsService.delNews(id);
        return "redirect:/news/list";
    }
   //发布新闻
    @GetMapping("/news/add")
    public String add(Model model){
        List<Category> list = categoryService.getAll();
        model.addAttribute("categorylist",list);
        return "views/news/add";
    }

    @PostMapping("/news/add")
    public String newsadd(News news){
        this.newsService.addNews(news);
        return "redirect:/news/list";
    }

    //修改新闻
    @GetMapping("/news/update/{id}")
    public String update(@PathVariable int id,Model model){
        List<Category> list = categoryService.getAll();
        model.addAttribute("categorylist",list);
        News k = newsService.getNewsById(id);
        model.addAttribute("news",k);
        return "views/news/update";
    }

    @PostMapping("/news/update")
    public String update(News news){
        newsService.updateNews(news);
        return "redirect:/news/list";
    }

    //查看新闻列表
    @GetMapping("/news/detail/{id}")
    public String newsdetail(@PathVariable int id,Model model){
        List<Category> list = categoryService.getAll();
        model.addAttribute("categorylist",list);
        News k = newsService.getNewsById(id);
        model.addAttribute("news",k);
        return "views/news/detail";
    }
}
