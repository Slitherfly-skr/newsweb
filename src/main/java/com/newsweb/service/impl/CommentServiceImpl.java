package com.newsweb.service.impl;

import com.newsweb.entity.Comment;
import com.newsweb.mapper.CommentMapper;
import com.newsweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> getAll() {
        return commentMapper.getAll();
    }

    @Override
    public boolean delComment(int commentID) {
        return commentMapper.delComment(commentID);
    }

    @Override
    public boolean delUserComment(int commentUserID){
        return commentMapper.delUserComment(commentUserID);
    }
}
