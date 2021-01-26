package com.newsweb.controller;

import com.newsweb.entity.Category;
import com.newsweb.service.CategoryService;
import com.newsweb.service.NewsService;
import com.newsweb.service.impl.CategoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService category;
    //展示新闻类别列表
    @GetMapping("/list")
    public String list(Model model){
        List<Category> list = category.getAll();
        model.addAttribute("list",list);
        return "views/category/list";
    }
    //增加新闻类型
    @GetMapping("/add")
    public String add(){
        return "views/category/add";
    }

    @PostMapping("/add")
    public String add(Category category){
        this.category.addCategory(category);
        return "redirect:/category/list";
    }
    //删除新闻类别
    @GetMapping("/del/{id}")
    public String del(@PathVariable int id){
        this.category.delCategory(id);
        return "redirect:/category/list";
    }
    //更新新闻类别
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id,Model model){
        Category k = this.category.getCategoryById(id);
        model.addAttribute("category",k);
        return "views/category/update";
    }

    @PostMapping("/update")
    public String update(Category category){
        this.category.updateCategory(category);
        return "redirect:/category/list";
    }
}
