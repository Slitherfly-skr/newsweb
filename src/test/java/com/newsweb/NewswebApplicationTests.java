package com.newsweb;

import com.newsweb.entity.Category;
import com.newsweb.entity.Comment;
import com.newsweb.entity.News;
import com.newsweb.mapper.CategoryMapper;
import com.newsweb.mapper.CommentMapper;
import com.newsweb.mapper.NewsMapper;
import com.newsweb.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NewswebApplicationTests {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Test
    void contextLoads() {
//        List<Comment> comment=  commentMapper.getAll();
//        System.out.println( comment);
        userMapper.delUser(3);
    }
}
