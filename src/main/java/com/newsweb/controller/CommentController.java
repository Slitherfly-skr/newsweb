package com.newsweb.controller;

import com.newsweb.entity.Category;
import com.newsweb.entity.Comment;
import com.newsweb.service.CategoryService;
import com.newsweb.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;
    @GetMapping("/list")
    public String list(Model model){
        List<Comment> list = commentService.getAll();
        model.addAttribute("list",list);
        return "views/comment/list";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable int id){
        commentService.delComment(id);
        return "redirect:/comment/list";
    }
}
